package com.insping.libra.relay;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.insping.Instances;
import com.insping.common.i18.I18nGreeting;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.proto.ReqServerHeartbeat.HeartbeatData;
import com.insping.libra.proto.ReqServerRegister;
import com.insping.libra.proto.ResServerList;
import com.insping.libra.relay.data.LibraServer;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.codec.data.LibraProtocolType;
import com.insping.log.LibraLog;

import io.netty.channel.ChannelHandlerContext;

public class ServerManager implements Instances {

    private ServerManager() {
    }

    private static ServerManager instance = new ServerManager();

    public static ServerManager getInstance() {
        return instance;
    }

    private Map<Integer, LibraServer> servers = new ConcurrentHashMap<>();

    public LibraServer searchServer(int serverID) {
        return servers.get(serverID);
    }

    public void addServer(LibraServer server) {
        servers.put(server.getServerID(), server);
    }

    public void deleteServer(int serverID) {
        servers.remove(serverID);
    }

    /**
     * 注册逻辑服务器到网关服务器
     *
     * @param ctx 通道
     * @param data 服务器注册信息
     * @return
     */
    public boolean registServer(ChannelHandlerContext ctx, ReqServerRegister.ServerRegisterData data) {
        //验证server
        if (!authRegisterServer(data)) {
            return false;
        }
        //注册Server
        LibraServer server = new LibraServer();
        server.setServerID(data.getServerID());
        server.setServerName(data.getServerName());
        server.setServerKey(data.getServerKey());
        server.setServerType(data.getServerType());
        server.setServerStatus(data.getServerStatus());
        server.setRegisterTime(data.getTime());
        server.setHeartbeatTime(data.getTime());
        server.setServerIp(data.getServerIp());
        server.setServerDesc(data.getServerDesc());
        server.setCtx(ctx);
        addServer(server);
        LibraLog.info("Server Regist >>>> ServerID = " + server.getServerID() + ", serverRegistTime = " + server.getRegisterTime());
        return true;
    }

    /**
     * 更新逻辑服务器相关数据
     *
     * @param data
     * @return
     */
    public boolean updateServer(HeartbeatData data) {
        //验证server
        if (!authUpdateServer(data)) {
            return false;
        }
        //更新服务器信息
        LibraServer server = searchServer(data.getServerID());
        if (server == null) {
            LibraLog.info("ServerManager-updateServer : server is null,serverID = " + data.getServerID());
            return false;
        }
        server.setServerID(data.getServerID());
        server.setServerName(data.getServerName());
        server.setServerKey(data.getServerKey());
        server.setServerType(data.getServerType());
        server.setServerStatus(data.getServerStatus());
        server.setHeartbeatTime(data.getTime());
        server.setServerDesc(data.getServerDesc());
        LibraLog.info("Heartbeat >>>> ServerID = " + server.getServerID() + ", heartbeatTime = " + server.getHeartbeatTime());
        return true;
    }

    private boolean authRegisterServer(ReqServerRegister.ServerRegisterData data) {
        //TODO 后面需要添加服务器列表,非列表内IP禁止登陆
        return true;
    }

    private boolean authUpdateServer(HeartbeatData data) {
        //TODO 后面需要添加服务器列表,非列表内IP禁止登陆
        return true;
    }

    /**
     * 向服务器转发消息
     *
     * @param message
     */
    public String sendMessage(LibraMessage message) {
        String result = null;
        if (message.getHead().getUserInfo() == null || message.getHead().getUserInfo().getUid() == 0) {
            LibraLog.error("ClientManager-sendMessage : uid of userinfo is null.ignore it.");
            result = I18nGreeting.GATEWAY_MESSAGE_USERINFO_INVALID;
        }
        int userServerID = clientMgr.searchServerID(message.getHead().getUserInfo().getUid());
        LibraServer server = serverMgr.searchServer(userServerID);
        if (server == null) {
            LibraLog.info("ServerManager-sendMessage : server is null");
            result = I18nGreeting.GATEWAY_SERVER_ISCLOSED;
        }
        if (server != null && (server.isClosed() || server.getCtx() == null)) {
            LibraLog.info("ServerManager-sendMessage : server is closed");
            result = I18nGreeting.GATEWAY_SERVER_ISCLOSED;
        }
        server.getCtx().channel().writeAndFlush(message);
        return result;
    }

    /**
     * 获取服务器列表(包含用户所在所有服务器的基本信息)
     *
     * @param data
     * @return
     */
    public LibraMessage getServerList(ReqAuthGetServerList.AuthGetServerListData data) {
        LibraMessage message = new LibraMessage();
        message.getHead().setProtocolID(LibraProtocolType.SERVER_LIST_RESPONSE);
        ResServerList.ServerListData.Builder builder = ResServerList.ServerListData.newBuilder();
        for (LibraServer server : servers.values()) {
            if (server == null)
                continue;
            builder.addServerList(ResServerList.ServerData.newBuilder()
                    .setServerID(server.getServerID())
                    .setServerName(server.getServerName())
                    .setServerStatus(server.getServerStatus())
                    .setServerDesc(server.getServerDesc()));
        }
        //TODO roles 暂时无(redis缓存表中获得)
        message.setBody(builder.build());
        return message;


    }
}

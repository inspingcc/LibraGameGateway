package com.insping.libra.relay;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import com.insping.Instances;
import com.insping.common.i18.I18nGreeting;
import com.insping.common.utils.TimeUtils;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.proto.ReqServerHeartbeat.HeartbeatData;
import com.insping.libra.proto.ReqServerRegister;
import com.insping.libra.proto.ResServerList;
import com.insping.libra.relay.data.LibraClient;
import com.insping.libra.relay.data.LibraServer;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.codec.data.LibraProtocolType;
import com.insping.libra.sock.net.module.ModuleType;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.libra.world.LibraConfig;
import com.insping.log.LibraLog;

import io.netty.channel.Channel;

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
     * @param channel 通道
     * @param data    服务器注册信息
     * @return
     */
    public boolean registServer(Channel channel, ReqServerRegister.ServerRegisterData data) {
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
        server.setChannel(channel);
        addServer(server);
        LibraLog.info("Server Register >>>> ServerID = " + server.getServerID() + ", serverRegisterTime = " + server.getRegisterTime());
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
        LibraLog.info("Heartbeat >>>> ServerID = " + server.getServerID() + ", heartbeatTime = " + TimeUtils.getTime(server.getHeartbeatTime()));
        return true;
    }

    private boolean authRegisterServer(ReqServerRegister.ServerRegisterData data) {
        //TODO 后面需要添加服务器列表,非列表内IP禁止登陆
        //if (data.getServerID() > 10000) {
        //    return false;
        //}
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
     * @return
     */
    public GeneralResponse sendMessageToServer(LibraMessage message) {
        GeneralResponse resp = new GeneralResponse();
        if (message.getHead().getUserInfo() == null || message.getHead().getUserInfo().getUid() == 0) {
            LibraLog.error("ClientManager-sendMessageToClient : uid of userInfo is null.ignore it.");
            resp.fail(I18nGreeting.GATEWAY_MESSAGE_USERINFO_INVALID);
            return resp;
        }
        int userServerID = clientMgr.searchServerID(message.getHead().getUserInfo().getUid());
        LibraServer server = serverMgr.searchServer(userServerID);
        if (server == null) {
            LibraLog.info("ServerManager-sendMessageToClient : server is null");
            resp.fail(I18nGreeting.GATEWAY_SERVER_ISCLOSED);
            return resp;
        }
        if (server != null && (server.isClosed() || server.getChannel() == null)) {
            LibraLog.info("ServerManager-sendMessageToClient : server is closed");
            resp.fail(I18nGreeting.GATEWAY_SERVER_ISCLOSED);
            return resp;
        }
        server.getChannel().writeAndFlush(message);
        return resp;
    }

    /**
     * 获取服务器列表(包含用户所在所有服务器的基本信息)
     *
     * @param client
     * @return
     */
    public LibraMessage buildServerList(LibraClient client) {
        LibraMessage message = new LibraMessage();
        message.getHead().setDestServerID(LibraConfig.SERVER_ID);
        message.getHead().setSrcServerID(-1);
        message.getHead().setProtocolID(ModuleType.SERVER_LIST_DATA);
        message.getHead().setUserInfo(client.getUserInfo());
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

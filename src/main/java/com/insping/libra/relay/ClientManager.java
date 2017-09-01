package com.insping.libra.relay;

import com.insping.Instances;
import com.insping.common.i18.I18nGreeting;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.proto.ReqSelectServer;
import com.insping.libra.relay.data.LibraClient;
import com.insping.libra.relay.data.LibraServer;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.log.LibraLog;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据处理类
 */
public class ClientManager implements Instances {
    private ClientManager() {
    }

    private static final ClientManager instance = new ClientManager();

    public static ClientManager getInstance() {
        return instance;
    }

    //客户端列表
    private Map<Long, LibraClient> clients = new ConcurrentHashMap<>();


    public LibraClient searchClient(long uid) {
        return clients.get(uid);
    }

    /**
     * 验证token
     *
     * @param data
     * @return
     */
    public boolean authToken(ChannelHandlerContext ctx, ReqAuthGetServerList.AuthGetServerListData data) {
        // TODO 验证token是否正确

        // 加入用户列表
        LibraClient client = new LibraClient(data.getUid(), ctx);
        clients.put(data.getUid(), client);
        return true;
    }

    /**
     * 转发消息到客户端
     *
     * @param message
     */
    public String sendMessage(LibraMessage message) {
        String result = null;
        if (message.getHead().getUserInfo() == null || message.getHead().getUserInfo().getUid() == 0) {
            LibraLog.error("ClientManager-sendMessage : uid of userinfo is null.ignore it.");
            result = I18nGreeting.GATEWAY_MESSAGE_USERINFO_INVALID;
        }
        long uid = message.getHead().getUserInfo().getUid();
        LibraClient client = clientMgr.searchClient(uid);
        if (client == null) {
            LibraLog.error("ClientManager-sendMessage : client is null");
            result = I18nGreeting.GATEWAY_CLIENT_ISCLOSED;
        }
        if (client != null && (client.isClosed() || client.isKick() || client.getCtx() == null)) {
            LibraLog.error("ClientManager-sendMessage : closed or kick!closed = " + client.isClosed() + ",Kick" + client.isKick());
            result = I18nGreeting.GATEWAY_CLIENT_ISCLOSED;
        }
        client.getCtx().channel().writeAndFlush(message);
        return result;
    }

    /**
     * 由uid获取绑定(登陆)的serverID
     *
     * @param uid
     * @return
     */
    public int searchServerID(long uid) {
        LibraClient client = clientMgr.searchClient(uid);
        if (client == null)
            return 0;
        return client.getServerID();
    }

    /**
     * 选择服务器
     *
     * @param data
     * @return
     */
    public String selectServer(ReqSelectServer.SelectServerData data) {
        LibraClient client = searchClient(data.getUid());
        if (client == null) {
            LibraLog.info("ClientManager-selectServer : client is null , uid =" + data.getUid());
            return I18nGreeting.GATEWAY_AUTH_INVALID;
        }
        LibraServer server = serverMgr.searchServer(data.getServerID());
        if (server == null) {
            LibraLog.info("ClientManager-selectServer : server is null , serverID =" + data.getServerID());
            return I18nGreeting.GATEWAY_SERVER_ISCLOSED;
        }
        client.setServerID(data.getServerID());
        return null;
    }
}

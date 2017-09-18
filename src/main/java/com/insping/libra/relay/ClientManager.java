package com.insping.libra.relay;

import com.insping.Instances;
import com.insping.common.i18.I18nGreeting;
import com.insping.common.utils.JsonUtil;
import com.insping.common.utils.TimeUtils;
import com.insping.libra.account.LibraToken;
import com.insping.libra.dao.redis.RedisSession;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.proto.ReqSelectServer;
import com.insping.libra.relay.data.LibraClient;
import com.insping.libra.relay.data.LibraServer;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.libra.world.LibraConfig;
import com.insping.log.LibraLog;
import io.netty.channel.Channel;

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
     * @param channel
     * @param data
     * @return
     */
    public boolean authToken(Channel channel, ReqAuthGetServerList.AuthGetServerListData data) {
        RedisSession redisSession = new RedisSession(true);
        String str = redisSession.get(LibraConfig.REDIS_TOKEN_PREFIX + data.getUid());
        LibraToken libraToken = JsonUtil.JsonToObject(str, LibraToken.class);
        if (libraToken == null) {
            LibraLog.info("ClientManager-authToken: auth is fail.libraToken is null ,uid = " + data.getUid());
            return false;
        }
        if (!libraToken.getToken().equals(data.getToken()) || libraToken.getExpiresTime() < TimeUtils.nowLong()) {
            LibraLog.info("ClientManager-authToken: auth is fail. uid = " + data.getUid());
            return false;
        }
        // 加入用户列表
        LibraClient client = new LibraClient(data, channel);
        clients.put(client.getUserInfo().getUid(), client);
        LibraLog.info("ClientManager-authToken: Auth is success.,uid = " + client.getUserInfo().getUid());
        // 发送服务器列表模块
        LibraMessage message = serverMgr.buildServerList(client);
        sendMessageToClient(message);
        return true;
    }

    /**
     * 合法客户端
     *
     * @param uid
     * @return
     */
    public boolean isValidClient(long uid) {
        return clients.get(uid) != null;
    }


    /**
     * 转发消息到客户端
     * @param message
     * @return
     */
    public GeneralResponse sendMessageToClient(LibraMessage message) {
        GeneralResponse resp = new GeneralResponse();
        if (message.getHead().getUserInfo() == null || message.getHead().getUserInfo().getUid() == 0) {
            LibraLog.error("ClientManager-sendMessageToClient : uid of userInfo is null.ignore it.");
            resp.fail(I18nGreeting.GATEWAY_MESSAGE_USERINFO_INVALID);
            return resp;
        }
        long uid = message.getHead().getUserInfo().getUid();
        LibraClient client = clientMgr.searchClient(uid);
        if (client == null) {
            LibraLog.error("ClientManager-sendMessageToClient : client is null");
            resp.fail(I18nGreeting.GATEWAY_CLIENT_ISCLOSED);
            return resp;
        }
        if (client != null && (client.isClosed() || client.isKick() || client.getChannel() == null)) {
            LibraLog.error("ClientManager-sendMessageToClient : closed or kick!closed = " + client.isClosed() + ",Kick" + client.isKick());
            resp.fail(I18nGreeting.GATEWAY_CLIENT_ISCLOSED);
            return resp;
        }
        client.getChannel().writeAndFlush(message);
        return resp;
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

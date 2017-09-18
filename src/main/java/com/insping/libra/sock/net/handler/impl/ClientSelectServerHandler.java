package com.insping.libra.sock.net.handler.impl;

import com.insping.common.i18.I18nGreeting;
import com.insping.common.utils.StringUtils;
import com.insping.common.utils.TimeUtils;
import com.insping.libra.proto.ReqSelectServer;
import com.insping.libra.relay.data.LibraClient;
import com.insping.libra.relay.data.LibraServer;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.handler.ServerHandler;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.log.LibraLog;

public class ClientSelectServerHandler extends ServerHandler {
    @Override
    public void doLogic(LibraMessage message, GeneralResponse resp) throws Exception {
        ReqSelectServer.SelectServerData data = (ReqSelectServer.SelectServerData) message.getBody();
        if (data == null) {
            LibraLog.error("RelayHandler-channelRead : ServerRegisterHandler body is invalid!");
            resp.fail(I18nGreeting.MESSAGE_BODY_INVALID);
            return;
        } else {
            LibraClient client = clientMgr.searchClient(data.getUid());
            if (client == null) {
                LibraLog.info("ClientManager-selectServer : client is null , uid =" + data.getUid());
                resp.fail(I18nGreeting.GATEWAY_AUTH_INVALID);
                return;
            }
            LibraServer server = serverMgr.searchServer(data.getServerID());
            if (server == null) {
                LibraLog.info("ClientManager-selectServer : server is null , serverID =" + data.getServerID());
                resp.fail(I18nGreeting.GATEWAY_SERVER_ISCLOSED);
                return;
            }
            client.setServerID(data.getServerID());
            LibraLog.info("uid (" + client.getUserInfo().getUid() + ") select server(" + client.getServerID() + ") ,time :" + TimeUtils.now().toString());
        }
    }
}

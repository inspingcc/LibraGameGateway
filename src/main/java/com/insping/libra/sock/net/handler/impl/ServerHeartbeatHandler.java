package com.insping.libra.sock.net.handler.impl;

import com.insping.common.i18.I18nGreeting;
import com.insping.libra.proto.ReqServerHeartbeat;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.handler.ServerHandler;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.log.LibraLog;

public class ServerHeartbeatHandler extends ServerHandler {
    @Override
    public void doLogic(LibraMessage message, GeneralResponse resp) throws Exception {
        ReqServerHeartbeat.HeartbeatData data = (ReqServerHeartbeat.HeartbeatData) message.getBody();
        if (data == null) {
            LibraLog.error("RelayHandler-channelRead : ServerHeartbeatHandler body is invalid!");
            resp.fail(I18nGreeting.MESSAGE_BODY_INVALID);
            return;

        }
        if (serverMgr.searchServer(data.getServerID()) == null) {
            resp.fail("server is null,gateway server is exception or server don't register!");
            return;
        }
        if (!serverMgr.updateServer(data)) {
            resp.fail("server reject heartbeat update!");
            return;
        }
    }
}

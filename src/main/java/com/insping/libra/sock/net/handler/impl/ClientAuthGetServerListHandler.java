package com.insping.libra.sock.net.handler.impl;

import com.insping.common.i18.I18nGreeting;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.handler.ServerHandler;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.log.LibraLog;

public class ClientAuthGetServerListHandler extends ServerHandler {
    @Override
    public void doLogic(LibraMessage message, GeneralResponse resp) throws Exception {
        // 客户端验证并获取服务器列表
        ReqAuthGetServerList.AuthGetServerListData data = (ReqAuthGetServerList.AuthGetServerListData) message.getBody();
        if (data == null) {
            LibraLog.error("RelayHandler-channelRead : clientAuth body is invalid!");
            resp.fail(I18nGreeting.GATEWAY_AUTH_INVALID);
            return;
        }
        if (!clientMgr.authToken(getChannel(), data)) {
            LibraLog.error("RelayHandler-channelRead : token is fail!");
            resp.fail(I18nGreeting.GATEWAY_AUTH_INVALID);
            return;
        }
    }
}

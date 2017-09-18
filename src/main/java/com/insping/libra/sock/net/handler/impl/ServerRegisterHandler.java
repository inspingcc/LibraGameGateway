package com.insping.libra.sock.net.handler.impl;

import com.insping.libra.proto.ReqServerRegister;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.handler.ServerHandler;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.log.LibraLog;

public class ServerRegisterHandler extends ServerHandler {

    @Override
    public void doLogic(LibraMessage message, GeneralResponse resp) throws Exception {
        ReqServerRegister.ServerRegisterData data = (ReqServerRegister.ServerRegisterData) message.getBody();
        if (data == null) {
            LibraLog.error("RelayHandler-channelRead : ServerRegisterHandler body is invalid!");
            resp.fail("ServerRegisterHandler body is invalid!");
            return;
        }
        if (!serverMgr.registServer(getChannel(), data)) {
            resp.fail("server reject register!");
            return;
        }
        // 重复登陆，拒绝
        // if (serverMgr.searchServer(data.getServerID()) != null) {
        // response.fail("重复登录 !");
        // } else {
        //
        // }
    }
}

package com.insping.libra.sock.net.handler;

import com.insping.Instances;
import com.insping.common.i18.I18nGreeting;
import com.insping.common.utils.StringUtils;
import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.proto.ReqSelectServer;
import com.insping.libra.proto.ReqServerHeartbeat;
import com.insping.libra.proto.ReqServerRegister;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.codec.data.LibraMessageType;

import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.log.LibraLog;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author houshanping
 */
public class SockLogicHandler extends ChannelInboundHandlerAdapter implements Instances {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LibraMessage message = (LibraMessage) msg;
        if (message.getHead() != null) {
            LibraMessageType messageType = LibraMessageType.search(message.getHead().getType());
            if (messageType == null) {
                LibraLog.error("ClientManager-handle : messageType is null ,typeID = " + message.getHead().getType());
                ctx.fireChannelRead(msg);
                return;
            }
            switch (messageType) {
                case MESSAGE_REQ: {
                    // 客户端发向服务器
                    String result = serverMgr.sendMessage(message);
                    if (!StringUtils.isNull(result)) {
                        sendErrorMessage(ctx, result);
                    }
                    break;
                }
                case MESSAGE_RESP: {
                    // 服务器发现客户端
                    String result = clientMgr.sendMessage(message);
                    if (!StringUtils.isNull(result)) {
                        sendErrorMessage(ctx, result);
                    }
                    break;
                }
                case CLIENT_AUTH: {
                    // 客户端验证并获取服务器列表
                    GeneralResponse response = new GeneralResponse();
                    ReqAuthGetServerList.AuthGetServerListData data;
                    try {
                        data = ReqAuthGetServerList.AuthGetServerListData.parseFrom((byte[]) message.getBody());
                    } catch (Exception e) {
                        LibraLog.error("SockLogicHandler-channelRead : CLIENT_AUTH catch Exception,e=" + e.getMessage());
                        data = null;
                    }
                    if (data == null) {
                        LibraLog.error("SockLogicHandler-channelRead : clientAuth body is invalid!");
                        response.fail(I18nGreeting.GATEWAY_AUTH_INVALID);
                    }
                    if (!clientMgr.authToken(ctx, data)) {
                        LibraLog.error("SockLogicHandler-channelRead : token is fail!");
                        response.fail(I18nGreeting.GATEWAY_AUTH_INVALID);
                    }
                    LibraMessage resp;
                    if (response.isSucc()) {
                        // 成功,发送服务器列表
                        resp = serverMgr.getServerList(data);
                    } else {
                        // 失败,发送错误消息
                        resp = response.result();
                    }
                    ctx.writeAndFlush(resp);
                    break;
                }
                case CLIENT_SELECT_SERVER: {
                    GeneralResponse response = new GeneralResponse();
                    ReqSelectServer.SelectServerData data;
                    try {
                        data = ReqSelectServer.SelectServerData.parseFrom((byte[]) message.getBody());
                    } catch (Exception e) {
                        LibraLog.error("SockLogicHandler-channelRead : CLIENT_SELECT_SERVER catch Exception,e=" + e.getMessage());
                        data = null;
                    }
                    if (data == null) {
                        LibraLog.error("SockLogicHandler-channelRead : ServerRegisterHandler body is invalid!");
                        response.fail("ServerRegisterHandler body is invalid!");
                    } else {
                        String result = clientMgr.selectServer(data);
                        if (!StringUtils.isNull(result)) {
                            response.fail(result);
                        }
                    }
                    LibraMessage libraMessage = response.result();
                    ctx.writeAndFlush(libraMessage);
                    break;
                }
                case SERVER_REGISTER_REQ: {
                    GeneralResponse response = new GeneralResponse();
                    ReqServerRegister.ServerRegisterData data;
                    try {
                        data = ReqServerRegister.ServerRegisterData.parseFrom((byte[]) message.getBody());
                    } catch (Exception e) {
                        LibraLog.error("SockLogicHandler-channelRead : SERVER_REGISTER_REQ catch Exception,e=" + e.getMessage());
                        data = null;
                    }
                    if (data == null) {
                        LibraLog.error("SockLogicHandler-channelRead : ServerRegisterHandler body is invalid!");
                        response.fail("ServerRegisterHandler body is invalid!");
                    }
                    if (!serverMgr.registServer(ctx, data)) {
                        response.fail("server reject register!");
                    }
                    // 重复登陆，拒绝
                    // if (serverMgr.searchServer(data.getServerID()) != null) {
                    // response.fail("重复登录 !");
                    // } else {
                    //
                    // }
                    LibraMessage libraMessage = response.result();
                    libraMessage.getHead().setType(LibraMessageType.SERVER_REGISTER_RESP.getValue());
                    ctx.writeAndFlush(libraMessage);
                    break;
                }
                case SERVER_REGISTER_RESP: {
                    break;
                }
                case SERVER_HEARTBEAT_REQ: {
                    GeneralResponse response = new GeneralResponse();
                    ReqServerHeartbeat.HeartbeatData data;
                    try {
                        data = ReqServerHeartbeat.HeartbeatData.parseFrom((byte[]) message.getBody());
                    } catch (Exception e) {
                        LibraLog.error("SockLogicHandler-channelRead : SERVER_HEARTBEAT_REQ catch Exception,e=" + e.getMessage());
                        data = null;
                    }
                    if (data != null) {
                        if (serverMgr.searchServer(data.getServerID()) == null) {
                            response.fail("server is null,gateway server is exception or server don't register!");
                        } else {
                            if (!serverMgr.updateServer(data)) {
                                response.fail("server reject heartbeat update!");
                            }
                        }
                    } else {
                        LibraLog.error("SockLogicHandler-channelRead : ServerHeartbeatHandler body is invalid!");
                        response.fail("ServerHeartbeatHandler body is invalid!");
                    }
                    LibraMessage libraMessage = response.result();
                    libraMessage.getHead().setType(LibraMessageType.SERVER_HEARTBEAT_RESP.getValue());
                    ctx.writeAndFlush(libraMessage);
                    break;
                }
                case SERVER_HEARTBEAT_RESP: {
                    break;
                }
                default: {
                    LibraLog.error("ClientManager-handle : messagetype is default ,typeID = " + message.getHead().getType());
                }
            }
        }
        ctx.fireChannelRead(msg);
    }

    private void sendErrorMessage(ChannelHandlerContext ctx, String msg) throws Exception {
        GeneralResponse response = new GeneralResponse();
        response.fail(msg);
        LibraMessage libraMessage = response.result();
        ctx.writeAndFlush(libraMessage);
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}

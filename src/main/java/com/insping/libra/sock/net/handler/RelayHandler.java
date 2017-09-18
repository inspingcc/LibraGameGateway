package com.insping.libra.sock.net.handler;

import com.insping.Instances;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.response.GeneralResponse;
import com.insping.libra.world.LibraConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author houshanping
 */
public class RelayHandler extends ChannelInboundHandlerAdapter implements Instances {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LibraMessage message = (LibraMessage) msg;
        // 新方法 , 统一使用目标serverID + protocolID 做消息处理
        if (message.getHead() == null || message.getHead().getSrcServerID() == LibraConfig.SERVER_ID) {
            ctx.fireChannelRead(msg);
            return;
        }
        //  转发处理
        GeneralResponse resp = null;
        // SrcServerID 为-1时表示目标为客户端
        if (message.getHead().getSrcServerID() == -1) {
            // 服务器发现客户端
            resp = clientMgr.sendMessageToClient(message);
        } else {
            // 客户端发向服务器
            resp = serverMgr.sendMessageToServer(message);
        }
        // 转发不成功的情况下是,返回原因
        if (resp.isFail()) {
            LibraMessage libraMessage = resp.build(message);
            ctx.writeAndFlush(libraMessage);
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}

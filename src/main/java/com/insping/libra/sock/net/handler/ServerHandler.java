package com.insping.libra.sock.net.handler;

import com.insping.Instances;
import com.insping.libra.sock.net.codec.data.LibraMessage;
import com.insping.libra.sock.net.response.GeneralResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author houshanping
 * @since 2017-07-12
 */
public abstract class ServerHandler implements Instances {
    // 当前channel
    Channel channel = null;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public abstract void doLogic(LibraMessage message, GeneralResponse resp) throws Exception;

}

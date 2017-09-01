package com.insping.libra.relay.data;

import io.netty.channel.ChannelHandlerContext;

public class LibraClient {
    private long uid;// uid
    private int serverID;// 当前服务器所在服务器ID
    private ChannelHandlerContext ctx;// 连接上下文 的通道
    private volatile boolean isClosed = false;// 是否关闭的标识
    private boolean isKick = false;// 是否被踢下线

    public  LibraClient(long uid, ChannelHandlerContext ctx) {
        this.uid = uid;
        this.ctx = ctx;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getServerID() {
        return serverID;
    }

    public void setServerID(int serverID) {
        this.serverID = serverID;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public boolean isKick() {
        return isKick;
    }

    public void setKick(boolean kick) {
        isKick = kick;
    }
}

package com.insping.libra.relay.data;

import com.insping.libra.proto.ReqAuthGetServerList;
import com.insping.libra.sock.net.codec.data.UserInfo;
import io.netty.channel.Channel;

public class LibraClient {
    private UserInfo userInfo;//userInfo
    private int serverID;// 当前服务器所在服务器ID
    private Channel channel;// 连接上下文 的通道
    private volatile boolean isClosed = false;// 是否关闭的标识
    private boolean isKick = false;// 是否被踢下线

    public LibraClient( ReqAuthGetServerList.AuthGetServerListData data, Channel channel) {
        this.userInfo = new UserInfo(data.getUid(), data.getCid(), data.getEid());
        this.channel = channel;
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getServerID() {
        return serverID;
    }

    public void setServerID(int serverID) {
        this.serverID = serverID;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
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

package com.insping.libra.sock.net.codec.data;

import com.insping.Instances;

public class LibraHead implements Instances {
	private int destServerID;// 来源serverId
	private int srcServerID;// 目的serverId
	private byte type;// 类型
	private int protocolID;// 协议ID 决定使用哪个handler进行处理(暂时仅使用protocolID)
	private int messageID;// 消息ID 决定body使用什么方式解析(暂未使用)
	private long requestID; // 用于同步的ID
	private UserInfo userInfo = new UserInfo();// 用户标识

	public LibraHead() {
	}

	public int getDestServerID() {
		return destServerID;
	}

	public void setDestServerID(int destServerID) {
		this.destServerID = destServerID;
	}

	public int getSrcServerID() {
		return srcServerID;
	}

	public void setSrcServerID(int srcServerID) {
		this.srcServerID = srcServerID;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public int getProtocolID() {
		return protocolID;
	}

	public void setProtocolID(int protocolID) {
		this.protocolID = protocolID;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public long getRequestID() {
		return requestID;
	}

	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}

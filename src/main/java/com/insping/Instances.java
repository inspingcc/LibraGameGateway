package com.insping;import com.insping.libra.relay.ClientManager;import com.insping.libra.relay.ServerManager;public interface Instances {	public static final ClientManager clientMgr = ClientManager.getInstance();	public static final ServerManager serverMgr = ServerManager.getInstance();}
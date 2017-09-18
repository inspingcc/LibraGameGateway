package com.insping;

import com.insping.libra.dao.redis.RedisSessionUtil;
import com.insping.libra.sock.SockServer;
import com.insping.libra.world.LibraConfig;
import com.insping.log.LibraLog;

public class GatewayServerApp implements Instances {
    public static void main(String[] args) {
        // 日志初始化
        LibraLog.init();
        // 加载config
        LibraConfig.load();
        // 加载handlers
        handlerMgr.register();
        // 初始化redis
        RedisSessionUtil.getInstance();
        // 启动Socket服务
        SockServer.getInstance().start();
    }
}

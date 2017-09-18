package com.insping.common.i18;

public interface I18nGreeting {
    // 数据包异常
    String MESSAGE_BODY_INVALID = "message_body_invalid";
    //身份验证非法
    String GATEWAY_AUTH_INVALID = "gateway_auth_invalid";
    // 消息头的userInfo错误
    String GATEWAY_MESSAGE_USERINFO_INVALID = "gateway_message_userinfo_invalid";
    // 服务器未开启
    String GATEWAY_SERVER_ISCLOSED = "gateway_server_isclosed";
    // 客户端已下线
    String GATEWAY_CLIENT_ISCLOSED = "gateway_client_isclosed";
    // 拒绝服务
    String GATEWAY_DENY_SERVICE = "gateway_deny_service";
}

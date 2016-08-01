package com.infinite.framework.router.entity;

/**
 * Created by hx on 16-7-6.
 */
public enum ResponseCode {

    SUCCESS("0", "成功"),
    AUTH_ACCOUNT_USERNAME_EMPTY("100", "认证失败，请输入用户名。"),
    AUTH_ACCOUNT_PASSORD_EMPTY("101", "认证失败，请输入密码。"),
    AUTH_ACCOUNT_ERROR("102", "认证失败，用户信息有误。"),
    AUTH_ACCOUNT_RETRY_LIMIT("103", "认证失败，错误次数过多，请10分钟后重新尝试。"),
    AUTH_PERMISION_NO("103", "没有权限操作。"),
    ;
    public String code;
    public String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

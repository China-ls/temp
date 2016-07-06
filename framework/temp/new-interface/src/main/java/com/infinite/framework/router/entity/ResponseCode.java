package com.infinite.framework.router.entity;

/**
 * Created by hx on 16-7-6.
 */
public enum ResponseCode {

    SUCCESS("0", "成功"),
    AUTH_ACCOUNT_ERROR("100", "认证失败，用户信息有误。"),
    AUTH_PERMISION_NO("101", "没有权限操作。"),
    ;
    public String code;
    public String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

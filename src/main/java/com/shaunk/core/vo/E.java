package com.shaunk.core.vo;

/**
 * @Project shaun
 * @Package com.shaun.api
 * @Name RCode
 * @Version 1.0
 * @Data: 2019/4/18 3:55 PM
 * @User: shaunk
 * @Description: TODO
 */
public enum E {

    // 正常
    SUCCESS(1, "ok"),

    //
    FAIL(0, "error"),

    // 业务自定义错误
    // 用户常见错误
    USER_NOT_FOUND(0, "用户不存在"),

    USER_PASSWORD_ERROR(0, "密码错误"),

    USER_AUTH_FAIL(0, "缺少token"),

    USER_AUTH_EXPIRE(0, "token失效"),

    USER_AUTH_ILLEGAL(0, "非法请求"),

    USER_IS_LOCK(0, "用户被禁用"),

    USER_NOT_ROLE(0, "用户无权限"),

    // 服务器常见错误
    SERVER_ERR_500(500, "服务器错误"),

    SERVER_ERR_400(400, "资源不存在"),

    SERVER_BUSY(401, "服务器繁忙"),


    REQ_PARAMS_ERROR(0, "参数错误"),


    ;

    /**
     * code编码
     */
    private Integer code;
    /**
     * 中文信息描述&提示信息
     */
    private String message;

    E(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

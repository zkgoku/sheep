package com.shaunk.core.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Project shaun
 * @Package com.shaun.api
 * @Name R
 * @Version 1.0
 * @Data: 2019/4/18 3:09 PM
 * @Author: shaunk
 * @Description: API统一返回model
 */
@Data
@Builder
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1193626139359107996L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T result;


    public R(E e) {
        this.code = e.getCode();
        this.message = e.getMessage();
    }

    public R(E e, T data) {
        this.code = e.getCode();
        this.message = e.getMessage();
        this.result = data;
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.result = data;
    }


    public static R ok(E e) {
        return new R(e);
    }


    public static R ok() {
        return new R(E.SUCCESS);
    }

    public static R ok(String message) {
        return new R(E.SUCCESS.getCode(), message);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R(E.SUCCESS.getCode(), message, data);
    }

    public static <T> R<T> ok(T data) {
        return new R(E.SUCCESS, data);
    }

    public static <T> R<T> fail() {
        return new R(E.FAIL);
    }

    public static <T> R<T> fail(String message) {
        return new R(E.FAIL.getCode(), message);
    }

    public static <T> R<T> fail(String message, T data) {
        return new R(E.FAIL.getCode(), message, data);
    }

    public static <T> R<T> info(E e) {
        return new R(e);
    }

    public static <T> R<T> info(E e, T data) {
        return new R(e, data);
    }

    public static <T> R<T> info(Integer code, String msg, T data) {
        return new R(code, msg, data);
    }

}

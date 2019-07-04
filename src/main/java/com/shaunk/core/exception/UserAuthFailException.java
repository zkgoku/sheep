package com.shaunk.core.exception;

/**
 * @Project sheep
 * @Package com.shaunk.core.exception
 * @Name UserAuthErrorException
 * @Version 1.0
 * @Data: 2019/6/29 10:10 AM
 * @User: shaunk
 * @Description: 用户授权失败
 */
public class UserAuthFailException extends Exception{

    public UserAuthFailException() {
        super();
    }

    public UserAuthFailException(String message) {
        super(message);
    }
}

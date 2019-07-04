package com.shaunk.core.exception;

/**
 * @Project sheep
 * @Package com.shaunk.core.exception
 * @Name UnknownAccountException
 * @Version 1.0
 * @Data: 2019/6/28 4:48 PM
 * @User: shaunk
 * @Description: 账户不存在异常
 */
public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}

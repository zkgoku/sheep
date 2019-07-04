package com.shaunk.core.exception;

/**
 * @Project sheep
 * @Package com.shaunk.core.exception
 * @Name UnknownAccountException
 * @Version 1.0
 * @Data: 2019/6/28 4:48 PM
 * @User: shaunk
 * @Description: 账户密码错误
 */
public class UserPasswordErrorException extends Exception{

    public UserPasswordErrorException() {
        super();
    }

    public UserPasswordErrorException(String message) {
        super(message);
    }
}

package com.shaunk.core.intercepter;

import com.shaunk.core.vo.UserInfo;

/**
 * @Project sheep
 * @Package com.shaunk.core.intercepter
 * @Name UserContextHolder1
 * @Version 1.0
 * @Data: 2019/6/28 3:50 PM
 * @Author: shaunk
 * @Description: 系统用户Holder
 */
public class UserContextHolder {

    public static ThreadLocal<UserInfo> context = new ThreadLocal<UserInfo>();

    public static UserInfo get() {
        return context.get();
    }

    public static void set(UserInfo user) {
        context.set(user);
    }

    public static void remove() {
        context.remove();
    }
}

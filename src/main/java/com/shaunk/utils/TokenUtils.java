package com.shaunk.utils;

import java.util.UUID;

/**
 * @Project sheep
 * @Package com.shaunk.utils
 * @Name TokenUtils
 * @Version 1.0
 * @Data: 2019/6/29 4:10 PM
 * @Author: shaunk
 * @Description: token工具类
 */
public class TokenUtils {


    public static String getTokenKey(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(getTokenKey());
    }
}

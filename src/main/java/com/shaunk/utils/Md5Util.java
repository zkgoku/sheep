package com.shaunk.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Project shaun
 * @Package com.utils
 * @Name Md5Util
 * @Version 1.0
 * @Data: 2019/5/28 4:04 PM
 * @User: shaunk
 * @Description: MD5加密工具
 */
public class Md5Util {

    public static String encrypt(String str){
        return DigestUtils.md5Hex(str);
    }

    public static boolean verify(String str, String md5){
        return encrypt(str).equals(md5);
    }

    public static void main(String[] args) {
        String a = "123456";
        String b = "e10adc3949ba59abbe56e057f20f883e";
        System.out.println(encrypt(a));
        System.out.println(verify(a, b));
    }
}

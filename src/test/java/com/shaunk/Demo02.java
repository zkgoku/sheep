package com.shaunk;


import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project sheep
 * @Package com.shaunk
 * @Name Demo02
 * @Version 1.0
 * @Data: 2019/7/22 1:10 PM
 * @Author: shaunk
 * @Description: TODO
 */
public class Demo02 {
    public static void main(String[] args) throws Exception{
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(1, 100));
    }
}

package com.shaunk;

import java.util.Random;

/**
 * @Project sheep
 * @Package com.shaunk
 * @Name Demo
 * @Version 1.0
 * @Data: 2019/7/16 4:12 PM
 * @Author: shaunk
 * @Description: TODO
 */
public class Demo {

    public static void main(String[] args) {
//        new Thread(
//                () -> System.out.println("hello world")
//        ).start();

        Random random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

        random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

        random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

    }
}

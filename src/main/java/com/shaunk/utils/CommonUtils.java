package com.shaunk.utils;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Project sheep
 * @Package com.shaunk.utils
 * @Name CommonUtils
 * @Version 1.0
 * @Data: 2019/7/2 11:33 AM
 * @Author: shaunk
 * @Description: TODO
 */
public class CommonUtils {




    public static Map<String, String> toMap(List<String> list){
        Map<String, String> map = Maps.newHashMap();
        for (String s : list) {
            map.put(s, s);
        }
        return map;
    }

    public static Map<String, String> toMap(String[] list){
        Map<String, String> map = Maps.newHashMap();
        for (String s : list) {
            map.put(s, s);
        }
        return map;
    }
}

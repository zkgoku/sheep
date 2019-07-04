package com.shaunk.service.impl;

import com.shaunk.core.vo.UserInfo;
import com.shaunk.service.CacheServiceI;
import org.springframework.stereotype.Service;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name CacheServiceImpl
 * @Version 1.0
 * @Data: 2019/6/29 4:38 PM
 * @Author: shaunk
 * @Description: 缓存服务
 */
@Service
public class CacheServiceImpl implements CacheServiceI{


    @Override
    public UserInfo getUser(Integer userId) throws Exception{

        try {


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

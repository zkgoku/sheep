package com.shaunk.service;

import com.shaunk.core.vo.UserInfo;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name CacheServiceI
 * @Version 1.0
 * @Data: 2019/6/29 4:38 PM
 * @User: shaunk
 * @Description: TODO
 */
public interface CacheServiceI {

    UserInfo getUser(Integer userId) throws Exception;
}

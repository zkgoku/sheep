package com.shaunk.mapper;

import com.shaunk.core.vo.UserInfo;
import com.shaunk.entity.User;
import com.shaunk.vo.QueryUserVo;
import com.shaunk.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Project shaun
 * @Package com.shaun.mapper
 * @Name UserMapper
 * @Version 1.0
 * @Data: 2019/4/19 5:52 PM
 * @User: shaunk
 * @Description: TODO
 */
public interface UserMapper extends Mapper<User> {

    List<UserVo> listUser(QueryUserVo query);

    UserVo selectUserById(Integer userId);

    UserInfo selectUserInfoByUsername(String username);

    UserInfo selectUserInfoByUserId(Integer username);

    Integer selectUserUsernameIsExists(@Param(value = "username") String username, @Param(value = "userId") Integer userId);

}

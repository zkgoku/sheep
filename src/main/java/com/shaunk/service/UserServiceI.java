package com.shaunk.service;

import com.shaunk.core.vo.E;
import com.shaunk.core.vo.Q;
import com.shaunk.core.vo.R;
import com.shaunk.core.vo.UserInfo;
import com.shaunk.entity.MenuAction;
import com.shaunk.vo.*;

import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.service
 * @Name UserServiceI
 * @Version 1.0
 * @Data: 2019/6/29 2:45 PM
 * @Author: shaunk
 * @Description: 用户服务
 */
public interface UserServiceI {

    /**
     * 登陆
     * @param loginVo
     * @return
     * @throws Exception
     */
    R login(LoginVo loginVo) throws Exception;


    /**
     * 放入用户信息 到缓存中
     * @param userInfo
     */
    void setUserInfoByCache(UserInfo userInfo);

    /**
     * 获取用户信息 从缓存中
     * @param userId
     * @return
     */
    UserInfo getUserInfoByCache(String userId);

    UserInfo getUserInfoByCache(Integer userId);

    /**
     * 删除缓存
     * @param userId
     */
    void removeUserInfoByCache(String userId);

    /**
     * 用户分页列表
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    R pageUser(QueryUserVo queryUserVo) throws Exception;

    /**
     * 获取用户信息  从用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    R getUser(Integer userId) throws Exception;

    /**
     * 获取用户信息
     * @return
     * @throws Exception
     */
    R getUser() throws Exception;

    /**
     * 登出
     * @return
     * @throws Exception
     */
    R logout() throws Exception;

    /**
     * 用户菜单
     * @param userId
     * @return
     */
    List<MenuVo> getUserMenu(Integer userId);

    /**
     * 用户下权限
     * @param userId
     * @return
     */
    List<MenuActionVo> getUserMenuAction(Integer userId);

    /**
     * 新增用户信息
     * @param userVo
     * @return
     * @throws Exception
     */
    R addUser(UserVo userVo) throws Exception;

    /**
     * 编辑用户信息
     * @param userVo
     * @return
     * @throws Exception
     */
    R editUser(UserVo userVo) throws Exception;

    /**
     * 操作用户
     * @param userVo
     * @return
     * @throws Exception
     */
    R operUser(UserVo userVo) throws Exception;

    /**
     * 分页
     * @param queryNoticeVO
     * @return
     * @throws Exception
     */
    R pageNotice(QueryNoticeVO queryNoticeVO) throws Exception;

    /**
     * 新增通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    R addNotice(NoticeVO noticeVO) throws Exception;

    /**
     * 编辑通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    R editNotice(NoticeVO noticeVO) throws Exception;

    /**
     * 操作通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    R operNotice(NoticeVO noticeVO) throws Exception;

}

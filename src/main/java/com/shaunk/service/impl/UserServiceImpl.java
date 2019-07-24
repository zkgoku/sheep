package com.shaunk.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.shaunk.core.intercepter.UserContextHolder;
import com.shaunk.core.vo.R;
import com.shaunk.core.vo.UserInfo;
import com.shaunk.entity.Notice;
import com.shaunk.entity.User;
import com.shaunk.entity.UserRole;
import com.shaunk.mapper.MenuMapper;
import com.shaunk.mapper.NoticeMapper;
import com.shaunk.mapper.UserMapper;
import com.shaunk.mapper.UserRoleMapper;
import com.shaunk.service.UserServiceI;
import com.shaunk.utils.JwtUtil;
import com.shaunk.utils.Md5Util;
import com.shaunk.utils.TokenUtils;
import com.shaunk.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name UserServiceImpl
 * @Version 1.0
 * @Data: 2019/6/29 2:46 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Service
@Slf4j
public class UserServiceImpl implements UserServiceI{


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public R login(LoginVo loginVo) throws Exception{

        try {
            log.info("<用户登陆>,用户信息->{}", loginVo);
            UserInfo userInfo = userMapper.selectUserInfoByUsername(loginVo.getUsername());

            // 是否存在
            if (null == userInfo){
                log.error("<用户不存在>,用户信息->{}", loginVo);
                return R.fail("用户不存在");
            }

            // 密码是否正确
            if (false){
                log.error("<密码错误>,用户信息->{}", loginVo);
                return R.fail("密码错误");
            }

            // 用户状态是否禁用
            if (userInfo.getStatus() == -1){
                log.error("<用户被禁用>,用户信息->{}", loginVo);
                return R.fail("用户被禁用,请联系管理员");
            }

            // 权限角色是否分配
            if (null == userInfo.getRoleId()){
                log.error("<用户无资源权限>,用户信息->{}", loginVo);
                return R.fail("用户无资源权限,请联系管理员");
            }
            // 组装权限下的菜单
            List<MenuVo> menuVos = this.getUserMenu(userInfo.getId());
            if (menuVos == null || menuVos.size() == 0){
                log.error("<用户无资源权限>,用户信息->{}", loginVo);
                return R.fail("用户无资源权限,请联系管理员");
            }
            userInfo.setMenus(menuVos);

            // 生成token
            UserInfo cacheUserInfo = getUserInfoByCache(userInfo.getId());
            if (cacheUserInfo == null){
                userInfo.setToken(JwtUtil.generateToken(userInfo));
                // 放入缓存信息
                this.setUserInfoByCache(userInfo);
            }

            // 未读消息

            return R.ok(userInfo);
        }catch (Exception e){
            log.error("login", e);
        }
        return R.fail();
    }

    @Override
    public void setUserInfoByCache(UserInfo userInfo) {
        // 命名规则：模块:用户:标识
        String key = "admin:user:%s";
        stringRedisTemplate.opsForValue().set(String.format(key, userInfo.getId()), JSON.toJSONString(userInfo));
    }

    @Override
    public UserInfo getUserInfoByCache(String userId) {

        try {

            String key = "admin:user:%s";
            String stringUserInfo = stringRedisTemplate.opsForValue().get(String.format(key, userId));

            return JSON.parseObject(stringUserInfo, UserInfo.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public UserInfo getUserInfoByCache(Integer userId) {
        return getUserInfoByCache(String.valueOf(userId));
    }

    @Override
    public void removeUserInfoByCache(String userId) {
        String key = "admin:user:%s";
        stringRedisTemplate.delete(String.format(key, userId));
    }

    @Override
    public R pageUser(QueryUserVo queryUserVo) throws Exception{
        PageHelper.startPage(queryUserVo.getPageNo(), queryUserVo.getPageSize());
        return R.ok(new PageInfo<>(userMapper.listUser(queryUserVo)));
    }

    @Override
    public R getUser(Integer userId) throws Exception {

        UserInfo userInfo = this.getUserInfoByCache(userId + "");
        if (userInfo == null) {
            userInfo = userMapper.selectUserInfoByUserId(userId);
            // 初始化菜单
            userInfo.setMenus(getUserMenu(userId));
            // 更新缓存
            this.setUserInfoByCache(userInfo);
        }

        return R.ok(userInfo);
    }

    @Override
    public R getUser() throws Exception {
        UserInfo userInfo = UserContextHolder.get();
        return this.getUser(userInfo.getId());
    }

    @Override
    public R logout() throws Exception {
        UserInfo userInfo = UserContextHolder.get();
        this.removeUserInfoByCache(String.valueOf(userInfo.getId()));
        return R.ok();
    }

    @Override
    public List<MenuVo> getUserMenu(Integer userId) {

        List<MenuVo> index = Lists.newArrayList();
        MenuVo indexVo = new MenuVo();
        indexVo.setCode("");
        indexVo.setTitle("主页");
        indexVo.setComponent("BasicLayout");
        List<MenuVo> list = menuMapper.listMenuByUserId(userId);
        List<MenuTreeVo> listAction =  menuMapper.listUserMenuAction(userId);
        List<MenuVo> list1 = getMenuItem(0, 1, list);
        for (MenuVo menuVo : list1) {
            if (menuVo.getType() == 2){
                menuVo.setPermission(getMenuActionItem(menuVo.getId(), listAction));
            }else {
                List<MenuVo> list2 = getMenuItem(menuVo.getId(), 2, list);
                for (MenuVo vo : list2) {
                    if (vo.getType() == 2){
                        vo.setPermission(getMenuActionItem(vo.getId(), listAction));
                    }else {
                        List<MenuVo> list3 = getMenuItem(vo.getId(), 3, list);
                        for (MenuVo menuVo1 : list3) {
                            menuVo1.setPermission(getMenuActionItem(menuVo1.getId(), listAction));
                        }
                        vo.setChildren(list3);
                    }
                }
                menuVo.setChildren(list2);
            }
        }
        indexVo.setChildren(list1);
        index.add(indexVo);
        return index;
    }

    private List<MenuVo> getMenuItem(Integer pid, Integer level, List<MenuVo> list){
        List<MenuVo> treeVos = Lists.newArrayList();
        for (MenuVo menu : list) {
            String tempParentId = String.valueOf(menu.getParentId());
            String tempLevel = String.valueOf(menu.getLevel());
            if (tempParentId.equals(pid+"") && tempLevel.equals(level + "") ){
                treeVos.add(menu);
            }
        }
        return treeVos;
    }

    private String[] getMenuActionItem(Integer menuId, List<MenuTreeVo> list){
        List<String> result = Lists.newArrayList();
        for (MenuTreeVo menuTreeVo : list) {
            if (menuId.equals(menuTreeVo.getMenuId())){
                result.add(menuTreeVo.getCode());
            }
        }
        String[] arr = new String[result.size()];
        return result.toArray(arr);
    }

    @Override
    public List<MenuActionVo> getUserMenuAction(Integer userId) {
        return null;
    }

    @Override
    public R addUser(UserVo userVo) throws Exception {

        try {
            if (userMapper.selectUserUsernameIsExists(userVo.getUsername(), null) > 0){
                return R.fail("添加失败,用户名已存在");
            }

            User user = new User();
            BeanUtils.copyProperties(userVo, user);
            // 密码处理
            user.setPassword(Md5Util.encrypt(userVo.getPassword()));
            // 头像暂不处理
            user.setTokenKey(TokenUtils.getTokenKey());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insert(user);

            // 分配角色 坑位
            UserRole userRole = UserRole.builder().build();
            userRole.setUserId(user.getId());
            userRole.setRoleId(userVo.getRoleId());
            userRoleMapper.insert(userRole);
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok();
    }

    @Override
    public R editUser(UserVo userVo) throws Exception {

        try {
            if (userMapper.selectUserUsernameIsExists(userVo.getUsername(), userVo.getId()) > 0){
                return R.fail("编辑失败,用户名已存在");
            }
            User user = new User();
            user.setId(userVo.getId());
            user.setUsername(userVo.getUsername());
            user.setNickName(userVo.getNickName());
            user.setPhone(userVo.getPhone());
            user.setAvatar(userVo.getAvatar());
            user.setEmail(userVo.getEmail());
            user.setStatus(userVo.getStatus());
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);

            // 分配角色
            UserRole userRole = userRoleMapper.selectOne(new UserRole(user.getId()));
            userRole.setUserId(user.getId());
            userRole.setRoleId(userVo.getRoleId());
            userRoleMapper.updateByPrimaryKey(userRole);
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok();
    }

    @Override
    public R operUser(UserVo userVo) throws Exception {

        try {

            User user = userMapper.selectOne(new User(userVo.getId()));
            switch (userVo.getAction()){
                // 重置密码
                case 1:
                    user.setPassword(Md5Util.encrypt("123456"));
                    userMapper.updateByPrimaryKeySelective(user);
                    break;
                // 用户删除
                case 2:
                    userMapper.delete(user);
                    break;
                // 禁用用户
                case 3:
                    user.setStatus(0);
                    userMapper.updateByPrimaryKeySelective(user);
                    break;
                // 开启用户
                case 4:
                    user.setStatus(1);
                    userMapper.updateByPrimaryKeySelective(user);
                    break;
                default:
                    // todo everything
                    break;
            }
            // 清除缓存
            this.removeUserInfoByCache(String.valueOf(user.getId()));
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok("操作成功");
    }

    @Override
    public R pageNotice(QueryNoticeVO queryNoticeVO) throws Exception {

        PageHelper.startPage(queryNoticeVO.getPageNo(), queryNoticeVO.getPageSize());

        return R.ok(new PageInfo<>(noticeMapper.listNotice(queryNoticeVO)));
    }

    @Override
    public R addNotice(NoticeVO noticeVO) throws Exception {

        UserInfo userInfo = UserContextHolder.get();
        Notice notice = new Notice();
        BeanUtils.copyProperties(noticeVO, notice);
        notice.setCreateTime(new Date());
        notice.setUserId(userInfo.getId());
        noticeMapper.insert(notice);
        return R.ok("保存成功");
    }

    @Override
    public R editNotice(NoticeVO noticeVO) throws Exception {

        Notice notice = noticeMapper.selectOne(new Notice(noticeVO.getId()));
        notice.setTitle(noticeVO.getTitle());
        notice.setContent(noticeVO.getContent());
        notice.setContentHtml(noticeVO.getContentHtml());
        notice.setStatus(noticeVO.getStatus());
        noticeMapper.updateByPrimaryKeySelective(notice);
        return R.ok("修改成功");
    }

    @Override
    public R operNotice(NoticeVO noticeVO) throws Exception {

        try {

            Notice notice = noticeMapper.selectOne(new Notice(noticeVO.getId()));
            switch (noticeVO.getAction()){
                // 删除
                case 1:
                    noticeMapper.delete(notice);
                    break;
                // 上线
                case 2:
                    notice.setStatus(1);
                    noticeMapper.updateByPrimaryKeySelective(notice);
                    break;
                // 下线
                case 3:
                    notice.setStatus(-1);
                    noticeMapper.updateByPrimaryKeySelective(notice);
                    break;
                default:
                    // todo everything
                    break;
            }
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok("操作成功");
    }
}

package com.shaunk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shaunk.core.vo.R;
import com.shaunk.entity.Role;
import com.shaunk.entity.RoleMenu;
import com.shaunk.mapper.RoleMapper;
import com.shaunk.mapper.RoleMenuMapper;
import com.shaunk.service.RoleServiceI;
import com.shaunk.utils.CommonUtils;
import com.shaunk.vo.QueryRoleVo;
import com.shaunk.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name RoleServiceImpl
 * @Version 1.0
 * @Data: 2019/7/1 5:34 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleServiceI{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public R pageRole(QueryRoleVo queryRoleVo) throws Exception {
        PageHelper.startPage(queryRoleVo.getPageNo(), queryRoleVo.getPageSize());
        return R.ok(new PageInfo<>(roleMapper.listRole(queryRoleVo)));
    }

    @Override
    public R listRole(QueryRoleVo queryRoleVo) throws Exception {
        return R.ok(roleMapper.listRole(queryRoleVo));
    }

    @Override
    public R addRole(RoleVo roleVo) throws Exception {

        try {
            Role role = new Role();
            BeanUtils.copyProperties(roleVo, role);
            role.setCreateTime(new Date());
            roleMapper.insert(role);
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok("添加成功");
    }

    @Override
    public R editRole(RoleVo roleVo) throws Exception {
        try {
            Role role = roleMapper.selectOne(new Role(roleVo.getId()));
            role.setName(roleVo.getName());
            role.setRemark(roleVo.getRemark());
            roleMapper.updateByPrimaryKeySelective(role);
        }catch (Exception e){
            log.error("user", e);
        }
        return R.ok("编辑成功");
    }

    @Override
    public R operRole(RoleVo roleVo) throws Exception {

        try {

            switch (roleVo.getAction()){
                // 删除
                case 1:
                    Role role = roleMapper.selectOne(new Role(roleVo.getId()));
                    if (role != null) {
                        roleMapper.delete(role);
                    }
                    break;
                default:// everything

                    break;
            }
            return R.ok();
        }catch (Exception e){
            log.error("user", e);
        }
        return R.fail("操作成功");
    }

    @Override
    public R getRoleMenu(RoleVo roleVo) throws Exception {

        return R.ok(roleMapper.selectRoleMenu(roleVo.getId()));
    }

    @Override
    public R roleAuth(RoleVo roleVo) throws Exception {

        String menus = roleVo.getMenuIds();
        Integer roleId = roleVo.getId();
        // 修改前权限
        List<String> roleMenus = roleMapper.selectRoleMenu(roleId);
        Map<String, String> roleMenusMap = CommonUtils.toMap(roleMenus);

        // 修改后权限
        String[] updateMenus = menus.split(",");
        Map<String, String> updateMenusMap = CommonUtils.toMap(updateMenus);

        // 需要删除的
        List<String> delMenus = Lists.newArrayList();

        for (String key : roleMenus) {
            if (!updateMenusMap.containsKey(key)){
                delMenus.add(key);
            }
        }
        for (String id : delMenus) {
            roleMenuMapper.delete(new RoleMenu(roleId, Integer.valueOf(id)));
        }
        // 需要新增的
        List<String> addMenus = Lists.newArrayList();
        for (String key : updateMenus) {
            if (!roleMenusMap.containsKey(key)){
                addMenus.add(key);
            }

        }
        for (String id : addMenus) {
            roleMenuMapper.insert(new RoleMenu(roleId, Integer.valueOf(id)));
        }
        return R.ok("授权成功");
    }

}

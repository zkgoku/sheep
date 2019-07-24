package com.shaunk.service;

import com.shaunk.core.vo.R;
import com.shaunk.vo.QueryRoleVo;
import com.shaunk.vo.RoleVo;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name RoleServiceI
 * @Version 1.0
 * @Data: 2019/7/1 5:33 PM
 * @Author: shaunk
 * @Description: TODO
 */
public interface RoleServiceI {

    /**
     * 角色分页列表
     * @param queryRoleVo
     * @return
     * @throws Exception
     */
    R pageRole(QueryRoleVo queryRoleVo) throws Exception;

    /**
     * 角色列表
     * @param queryRoleVo
     * @return
     * @throws Exception
     */
    R listRole(QueryRoleVo queryRoleVo) throws Exception;

    /**
     * 新增角色信息
     * @param roleVo
     * @return
     * @throws Exception
     */
    R addRole(RoleVo roleVo) throws Exception;

    /**
     * 编辑角色信息
     * @param roleVo
     * @return
     * @throws Exception
     */
    R editRole(RoleVo roleVo) throws Exception;

    /**
     * 操作角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    R operRole(RoleVo roleVo) throws Exception;

    /**
     * 获取角色菜单权限
     * @param roleVo
     * @return
     * @throws Exception
     */
    R getRoleMenu(RoleVo roleVo) throws Exception;

    R roleAuth(RoleVo roleVo) throws Exception;
}

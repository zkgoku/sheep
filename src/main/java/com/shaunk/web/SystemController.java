package com.shaunk.web;

import com.shaunk.core.vo.R;
import com.shaunk.service.MenuServiceI;
import com.shaunk.service.RoleServiceI;
import com.shaunk.service.UserServiceI;
import com.shaunk.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Project sheep
 * @Package com.shaunk.web
 * @Name SystemController
 * @Version 1.0
 * @Data: 2019/6/28 3:39 PM
 * @Author: shaunk
 * @Description: 系统管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class SystemController {


    @Autowired
    private UserServiceI userService;

    @Autowired
    private RoleServiceI roleService;

    @Autowired
    private MenuServiceI menuService;



    /**
     * 用户列表
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    @PostMapping("/page/user")
    public R pageUser(@ModelAttribute QueryUserVo queryUserVo) throws Exception {

        return userService.pageUser(queryUserVo);
    }

    /**
     * 新增用户
     * @param userVo
     * @return
     * @throws Exception
     */
    @PostMapping("/add/user")
    public R addUser(@ModelAttribute UserVo userVo) throws Exception {

        return userService.addUser(userVo);
    }

    /**
     * 编辑用户
     * @param userVo
     * @return
     * @throws Exception
     */
    @PostMapping("/edit/user")
    public R editUser(@ModelAttribute UserVo userVo) throws Exception {

        return userService.editUser(userVo);
    }

    /**
     * 用户操作
     *  1.密码充值
     *  2.删除用户
     *  3.禁用用户
     *  等等
     * @param userVo
     * @return
     * @throws Exception
     */
    @PostMapping("/oper/user")
    public R operUser(@ModelAttribute UserVo userVo) throws Exception {

        return userService.operUser(userVo);
    }


    /**
     * 用户权限列表
     * @param userVo
     * @return
     * @throws Exception
     */
    @PostMapping("/auth/user")
    public R authUser(@ModelAttribute UserVo userVo) throws Exception {

        return menuService.userTreeMenu(userVo.getId());
    }





    /**
     * 角色列表 分页
     * @param queryRoleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/page/role")
    public R pageRole(@ModelAttribute QueryRoleVo queryRoleVo) throws Exception {

        return roleService.pageRole(queryRoleVo);
    }

    /**
     * 角色列表
     * @return
     * @throws Exception
     */
    @PostMapping("/list/role")
    public R listRole(@ModelAttribute QueryRoleVo queryRoleVo) throws Exception {

        return roleService.listRole(queryRoleVo);
    }

    /**
     * 新增角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/add/role")
    public R addRole(@ModelAttribute RoleVo roleVo) throws Exception {

        return roleService.addRole(roleVo);
    }

    /**
     * 编辑角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/edit/role")
    public R editRole(@ModelAttribute RoleVo roleVo) throws Exception {

        return roleService.editRole(roleVo);
    }

    /**
     * 角色操作
     *  1.删除
     *  等等
     * @param roleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/oper/role")
    public R operRole(@ModelAttribute RoleVo roleVo) throws Exception {

        return roleService.operRole(roleVo);
    }


    /**
     * 角色菜单信息
     * @param roleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/role/menu")
    public R roleMenu(@ModelAttribute RoleVo roleVo) throws Exception {

        return roleService.getRoleMenu(roleVo);
    }

    /**
     * 菜单授权
     * @param roleVo
     * @return
     * @throws Exception
     */
    @PostMapping("/role/auth")
    public R roleAuth(@ModelAttribute RoleVo roleVo) throws Exception {

        return roleService.roleAuth(roleVo);
    }





    /**
     * 菜单列表 分页
     * @param queryMenuVo
     * @return
     * @throws Exception
     */
    @PostMapping("/page/menu")
    public R pageMenu(@ModelAttribute QueryMenuVo queryMenuVo) throws Exception {

        return menuService.pageMenu(queryMenuVo);
    }

    /**
     * 菜单列表
     * @param queryMenuVo
     * @return
     * @throws Exception
     */
    @PostMapping("/tree/menu")
    public R treeMenu(@ModelAttribute QueryMenuVo queryMenuVo) throws Exception {

        return menuService.treeMenu(queryMenuVo);
    }

    /**
     * 新增菜单
     * @param menuVo
     * @return
     * @throws Exception
     */
    @PostMapping("/add/menu")
    public R addMenu(@ModelAttribute MenuVo menuVo) throws Exception {

        return menuService.addMenu(menuVo);
    }

    /**
     * 编辑菜单
     * @param menuVo
     * @return
     * @throws Exception
     */
    @PostMapping("/edit/menu")
    public R editMenu(@ModelAttribute MenuVo menuVo) throws Exception {

        return menuService.editMenu(menuVo);
    }

    /**
     * 菜单操作
     *  1.删除
     *  等等
     * @param menuVo
     * @return
     * @throws Exception
     */
    @PostMapping("/oper/menu")
    public R operMenu(@ModelAttribute MenuVo menuVo) throws Exception {

        return menuService.operMenu(menuVo);
    }



    /**
     * 菜单列表
     * @param queryMenuActionVo
     * @return
     * @throws Exception
     */
    @PostMapping("/list/menuAction")
    public R treeMenu(@ModelAttribute QueryMenuActionVo queryMenuActionVo) throws Exception {

        return menuService.listMenuAction(queryMenuActionVo);
    }

    /**
     * 新增菜单
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    @PostMapping("/add/menuAction")
    public R addMenu(@ModelAttribute MenuActionVo menuActionVo) throws Exception {

        return menuService.addMenuAction(menuActionVo);
    }

    /**
     * 编辑菜单
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    @PostMapping("/edit/menuAction")
    public R editMenu(@ModelAttribute MenuActionVo menuActionVo) throws Exception {

        return menuService.editMenuAction(menuActionVo);
    }

    /**
     * 菜单操作
     *  1.删除
     *  等等
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    @PostMapping("/del/menuAction")
    public R delMenu(@ModelAttribute MenuActionVo menuActionVo) throws Exception {

        return menuService.delMenuAction(menuActionVo);
    }

    /**
     * 通知列表 分页
     * @param queryNoticeVO
     * @return
     * @throws Exception
     */
    @PostMapping("/page/notice")
    public R pageNotice(QueryNoticeVO queryNoticeVO) throws Exception {

        return userService.pageNotice(queryNoticeVO);
    }

    /**
     * 新增通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    @PostMapping("/add/notice")
    public R addNotice(NoticeVO noticeVO) throws Exception {

        return userService.addNotice(noticeVO);
    }

    /**
     * 编辑通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    @PostMapping("/edit/notice")
    public R editNotice(NoticeVO noticeVO) throws Exception {

        return userService.editNotice(noticeVO);
    }

    /**
     * 操作 通知
     * @param noticeVO
     * @return
     * @throws Exception
     */
    @PostMapping("/oper/notice")
    public R operNotice(@ModelAttribute NoticeVO noticeVO) throws Exception {

        return userService.operNotice(noticeVO);
    }

}

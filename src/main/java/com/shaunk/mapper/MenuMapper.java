package com.shaunk.mapper;

import com.shaunk.entity.Menu;
import com.shaunk.vo.MenuActionVo;
import com.shaunk.vo.MenuTreeVo;
import com.shaunk.vo.MenuVo;
import com.shaunk.vo.QueryMenuVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 */
public interface MenuMapper extends Mapper<Menu> {

//    // 全部菜单列表
    List<MenuVo> listMenu(QueryMenuVo queryMenuVo);

    List<MenuVo> listMenuByLevel(Integer level);

    List<MenuTreeVo> listMenuTreeByLevel(Integer level);

    List<MenuTreeVo> listMenuAction();
//
    List<MenuVo> listMenuByUserId(Integer userId);

    List<MenuActionVo> selectMenuActionByMenuId(Integer menuId);
//    // 根据父id查询菜单列表
//    List<MenuInfoVo> selectMenuByParentId(Integer pid);
//
//    // 菜单信息 根据主键id
//    MenuInfoVo selectMenuById(Integer id);
//
//    List<MenuInfoVo> selectMenuByRoleId(Integer roleId);
//
//    List<MenuActionInfoVo> selectMenuActionByRoleId(Integer roleId);
//
//    List<MenuActionInfoVo> selectMenuActionByMenuId(Integer menuId);
//
//    List<MenuTreeVo> selectMenuTreeByParentId(Integer pid);
//
//    List<MenuTreeVo> selectMenuTreeActionByMenuId(String menuId);
//
//    List<MenuTreeVo> selectAllMenuActions();
//
//    List<MenuTreeVo> selectAllMenus();
//
//    int deleteMenu(Integer menuId);
//
//    int deleteRoleMenu(Integer menuId);
//
//    int deleteMenuAction(Integer actionId);
//
//    int deleteRoleMenuAction(Integer actionId);

}

package com.shaunk.mapper;

import com.shaunk.entity.Menu;
import com.shaunk.vo.MenuActionVo;
import com.shaunk.vo.MenuTreeVo;
import com.shaunk.vo.MenuVo;
import com.shaunk.vo.QueryMenuVo;
import org.apache.ibatis.annotations.Param;
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

    List<MenuTreeVo> listUserMenuTreeByLevel(@Param(value = "level") Integer level, @Param(value = "userId") Integer userId);

    List<MenuTreeVo> listUserMenuAction(Integer userId);


}

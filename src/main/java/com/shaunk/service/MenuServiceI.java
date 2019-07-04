package com.shaunk.service;

import com.shaunk.core.vo.R;
import com.shaunk.vo.MenuActionVo;
import com.shaunk.vo.MenuVo;
import com.shaunk.vo.QueryMenuActionVo;
import com.shaunk.vo.QueryMenuVo;

/**
 * @Project sheep
 * @Package com.shaunk.service
 * @Name MenuServiceI
 * @Version 1.0
 * @Data: 2019/7/1 5:36 PM
 * @Author: shaunk
 * @Description: TODO
 */
public interface MenuServiceI {

    /**
     * 菜单分页列表
     * @param queryMenuVo
     * @return
     * @throws Exception
     */
    R pageMenu(QueryMenuVo queryMenuVo) throws Exception;

    /**
     * 菜单列表 全部
     * @param queryMenuVo
     * @return
     * @throws Exception
     */
    R treeMenu(QueryMenuVo queryMenuVo) throws Exception;

    /**
     * 新增菜单信息
     * @param menuVo
     * @return
     * @throws Exception
     */
    R addMenu(MenuVo menuVo) throws Exception;

    /**
     * 编辑菜单信息
     * @param menuVo
     * @return
     * @throws Exception
     */
    R editMenu(MenuVo menuVo) throws Exception;

    /**
     * 操作菜单
     * @param menuVo
     * @return
     * @throws Exception
     */
    R operMenu(MenuVo menuVo) throws Exception;




    /**
     * 菜单列表 全部
     * @param queryMenuActionVo
     * @return
     * @throws Exception
     */
    R listMenuAction(QueryMenuActionVo queryMenuActionVo) throws Exception;

    /**
     * 新增菜单权限信息
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    R addMenuAction(MenuActionVo menuActionVo) throws Exception;

    /**
     * 编辑菜单权限信息
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    R editMenuAction(MenuActionVo menuActionVo) throws Exception;

    /**
     * 操作菜单
     * @param menuActionVo
     * @return
     * @throws Exception
     */
    R delMenuAction(MenuActionVo menuActionVo) throws Exception;


}

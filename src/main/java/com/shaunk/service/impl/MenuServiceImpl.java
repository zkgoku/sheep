package com.shaunk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.shaunk.core.vo.R;
import com.shaunk.entity.Menu;
import com.shaunk.entity.MenuAction;
import com.shaunk.mapper.MenuActionMapper;
import com.shaunk.mapper.MenuMapper;
import com.shaunk.service.MenuServiceI;
import com.shaunk.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.service.impl
 * @Name MenuServiceImpl
 * @Version 1.0
 * @Data: 2019/7/1 5:36 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuServiceI{

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuActionMapper menuActionMapper;


    @Override
    public R pageMenu(QueryMenuVo queryMenuVo) throws Exception {

        // 分页
        PageHelper.startPage(queryMenuVo.getPageNo(), queryMenuVo.getPageSize());
        List<MenuVo> list1 = menuMapper.listMenuByLevel(1);

        List<MenuVo> list2 = menuMapper.listMenuByLevel(2);
        List<MenuVo> list3 = menuMapper.listMenuByLevel(3);
        // 组合
        for (MenuVo m1Vo : list1) {
            List<MenuVo> temp2 = Lists.newArrayList();
            for (MenuVo m2Vo : list2) {
                String m1Id = String.valueOf(m1Vo.getId());
                String m2ParentId = String.valueOf(m2Vo.getParentId());
                String m2Id = String.valueOf(m2Vo.getId());
                if (m1Id.equals(m2ParentId)){
                    temp2.add(m2Vo);
                    List<MenuVo> temp3 = Lists.newArrayList();
                    for (MenuVo m3Vo : list3) {
                        String m3Id = String.valueOf(m3Vo.getParentId());
                        if (m2Id.equals(m3Id)){
                            temp3.add(m3Vo);
                        }
                    }
                    if (temp3 != null && temp3.size() > 0) {
                        Collections.sort(temp3, Comparator.comparing(MenuVo::getRank));
                        m2Vo.setChildren(temp3);
                    }
                }
            }
            if (temp2 != null && temp2.size() > 0) {
                Collections.sort(temp2, Comparator.comparing(MenuVo::getRank));
                m1Vo.setChildren(temp2);
            }
        }
        return R.ok(new PageInfo<>(list1));
    }

    @Override
    public R treeMenu(QueryMenuVo queryMenuVo) throws Exception {

        List<MenuTreeVo> list1 = menuMapper.listMenuTreeByLevel(1);

        List<MenuTreeVo> list2 = menuMapper.listMenuTreeByLevel(2);

        List<MenuTreeVo> list3 = menuMapper.listMenuTreeByLevel(2);

        List<MenuTreeVo> actions = menuMapper.listMenuAction();
        // 初始化tree
        initTreeMenu(list1, list2, list3, actions);
        return R.ok(list1);
    }

    @Override
    public R userTreeMenu(Integer userId) throws Exception {

        List<MenuTreeVo> list1 = menuMapper.listUserMenuTreeByLevel(1, userId);

        List<MenuTreeVo> list2 = menuMapper.listUserMenuTreeByLevel(2, userId);

        List<MenuTreeVo> list3 = menuMapper.listUserMenuTreeByLevel(3, userId);

        List<MenuTreeVo> actions = menuMapper.listUserMenuAction(userId);
        // 初始化tree
        initTreeMenu(list1, list2,list3, actions);

        return R.ok(list1);
    }

    private List<MenuTreeVo> initTreeMenu(List<MenuTreeVo> list1, List<MenuTreeVo> list2,  List<MenuTreeVo> list3, List<MenuTreeVo> actions){
        // 组长成树形
        for (MenuTreeVo m1Vo : list1) {
            // 如果是页面
            if (m1Vo.getType() == 2){
                m1Vo.setChildren(getMenuAction(m1Vo.getMenuId(), actions));
            }else {
                List<MenuTreeVo> temp2 = getMenu(m1Vo.getMenuId(), list2);
                for (MenuTreeVo m2Vo : temp2) {
                    if (m2Vo.getType() == 2){
                        m2Vo.setChildren(getMenuAction(m2Vo.getMenuId(), actions));
                    }else {
                        List<MenuTreeVo> temp3 = getMenu(m2Vo.getMenuId(), list3);
                        for (MenuTreeVo m3Vo : temp3) {
                            m3Vo.setChildren(getMenuAction(m3Vo.getMenuId(), actions));
                        }
                    }
                }
                Collections.sort(temp2, Comparator.comparing(MenuTreeVo::getRank));
                m1Vo.setChildren(temp2);
            }
        }
        return list1;
    }

    private List<MenuTreeVo> getMenu(Integer menuId, List<MenuTreeVo> list){
        List<MenuTreeVo> result = Lists.newArrayList();
        for (MenuTreeVo menuTreeVo : list) {
            if (menuTreeVo.getParentId().equals(menuId)){
                result.add(menuTreeVo);
            }
        }
        return result;
    }

    private List<MenuTreeVo> getMenuAction(Integer menuId, List<MenuTreeVo> list){
        List<MenuTreeVo> result = Lists.newArrayList();
        for (MenuTreeVo menuTreeVo : list) {
            if (menuTreeVo.getMenuId().equals(menuId)){
                result.add(menuTreeVo);
            }
        }
        return result;
    }

    @Override
    public R addMenu(MenuVo menuVo) throws Exception {

        try {

            Menu menu = new Menu();
            BeanUtils.copyProperties(menuVo, menu);
            menu.setCreateTime(new Date());
            menuMapper.insert(menu);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return R.ok("添加成功");
    }

    @Override
    public R editMenu(MenuVo menuVo) throws Exception {

        try {

            Menu menu = menuMapper.selectByPrimaryKey(new Menu(menuVo.getId()));
            menu.setTitle(menuVo.getTitle());
            menu.setCode(menuVo.getCode());
            menu.setIcon(menuVo.getIcon());
            menu.setStatus(menuVo.getStatus());
            menu.setType(menuVo.getType());
            menu.setRank(menuVo.getRank());
            menu.setRemark(menuVo.getRemark());
            menuMapper.updateByPrimaryKey(menu);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return R.ok("修改成功");
    }

    @Override
    public R operMenu(MenuVo menuVo) throws Exception {
        try {

            switch (menuVo.getAction()){
                // 删除
                case 1:
                    Menu menu = menuMapper.selectOne(new Menu(menuVo.getId()));
                    if (menu != null) {
                        menuMapper.delete(menu);
                    }
                    break;
                default:// everything

                    break;
            }
        }catch (Exception e){
            log.error("{}", e);
        }
        return R.ok("操作成功");
    }


    @Override
    public R listMenuAction(QueryMenuActionVo queryMenuActionVo) throws Exception {
        return R.ok(menuMapper.selectMenuActionByMenuId(queryMenuActionVo.getMenuId()));
    }

    @Override
    public R addMenuAction(MenuActionVo menuActionVo) throws Exception {
        MenuAction menuAction = new MenuAction();
        BeanUtils.copyProperties(menuActionVo, menuAction);
        menuAction.setCreateTime(new Date());
        menuActionMapper.insertSelective(menuAction);
        return R.ok("添加成功");
    }

    @Override
    public R editMenuAction(MenuActionVo menuActionVo) throws Exception {
        MenuAction params = MenuAction.builder().id(menuActionVo.getId()).build();
        MenuAction menuAction = menuActionMapper.selectByPrimaryKey(params);
        menuAction.setCode(menuActionVo.getCode());
        menuAction.setName(menuActionVo.getName());
        menuAction.setRemark(menuActionVo.getRemark());
        menuActionMapper.updateByPrimaryKeySelective(menuAction);
        return R.ok("修改成功");
    }

    @Override
    public R delMenuAction(MenuActionVo menuActionVo) throws Exception {
        MenuAction params = MenuAction.builder().id(menuActionVo.getId()).build();
        MenuAction menuAction = menuActionMapper.selectByPrimaryKey(params);
        if (menuAction != null) {
            menuActionMapper.delete(menuAction);
        }
        return R.ok("删除成功");
    }
}

package com.shaunk.vo;

import lombok.Data;

import java.util.List;

/**
 * @Project shaun
 * @Package com.common.qvo.system
 * @Name MenuTreeV0
 * @Version 1.0
 * @Data: 2019/5/8 3:24 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Data
public class MenuTreeVo {

    private String key;
    private String title;
    private List<MenuTreeVo> children;
    private boolean disabled = false;
    private boolean disableCheckbox = false;
    private boolean selectable = true;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 父节点
     */
    private Integer parentId;
    /**
     * 菜单等级
     */
    private Integer level;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 排序
     */
    private Integer rank;

    public void setStatus(Integer status) {
        this.status = status;
        if (status == 0){
            this.setDisabled(true);
            this.setDisableCheckbox(true);
        }
    }
}

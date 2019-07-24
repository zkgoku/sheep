package com.shaunk.vo;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.vo
 * @Name MenuVo
 * @Version 1.0
 * @Data: 2019/7/1 5:03 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Data
public class MenuVo {

    private Integer id;

    private String code;

    private String title;

    private String icon;

    private Integer parentId;

    private String component;

    private String path;

    private Integer level;

    private Integer status;

    private Integer type;

    private Integer rank;

    private String remark;

    private Integer action;

    private String[] permission;

    private List<MenuVo> children;


}

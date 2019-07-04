package com.shaunk.vo;

import lombok.Data;

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
public class MenuActionVo {

    private Integer id;

    private Integer menuId;

    private String name;

    private String code;

    private String remark;

    private String key;

    private boolean editable = false;

}

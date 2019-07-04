package com.shaunk.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleVo implements Serializable {

    private Integer id;

    private String name;

    private String remark;

    private Date createTime;

    /**
     *  操作信息
     */
    private Integer action;

    private String menuIds;
}

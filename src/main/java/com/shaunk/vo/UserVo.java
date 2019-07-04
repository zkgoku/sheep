package com.shaunk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project shaun
 * @Package com.shaun.model
 * @Name QUserVo
 * @Version 1.0
 * @Data: 2019/4/19 5:53 PM
 * @User: shaunk
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo implements Serializable{


    private Integer id;

    /**
     * 登录名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 权限id
     */
    private Integer roleId;

    /**
     * 权限名称
     */
    private String roleName;

    /**
     *  操作信息
     */
    private Integer action;


}

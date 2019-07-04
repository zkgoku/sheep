package com.shaunk.entity;

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
 * @Author: shaunk
 * @Description: TODO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "system_user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 登录名称
     */
    @Column(name = "username")
    private String username;

    /**
     * 登录密码 加密
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 用户手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户状态 -1:禁用 1:正常
     */
    @Column(name = "status")
    private Integer status;

    /**
     * token 秘钥
     */
    @Column(name = "token_key")
    private String tokenKey;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;



    public User(Integer id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }
}

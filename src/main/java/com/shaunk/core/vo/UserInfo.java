package com.shaunk.core.vo;

import com.shaunk.vo.MenuVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.core.vo
 * @Name UserInfo
 * @Version 1.0
 * @Data: 2019/6/28 3:49 PM
 * @Author: shaunk
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    private Integer id;

    /**
     * 登录名称
     */
    private String username;

    /**
     * 登录密码 加密
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
     * token
     */
    private String token;

    /**
     * 权限id
     */
    private Integer roleId;

    /**
     * 权限名称
     */
    private String roleName;

    /**
     * 拥有菜单
     */
    private List<MenuVo> menus;

}

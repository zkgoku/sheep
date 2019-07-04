package com.shaunk.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Project sheep
 * @Package com.shaunk.vo
 * @Name LoginVo
 * @Version 1.0
 * @Data: 2019/6/29 2:26 PM
 * @User: shaunk
 * @Description: TODO
 */
@Data
public class LoginVo {

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 1, max = 12, message = "用户名长度在1-12位")
    private String username;
    @NotEmpty(message = "密码名不能为空")
    @Size(min = 6, max = 8, message = "密码长度在6-8")
    private String password;
}

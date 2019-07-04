package com.shaunk.web;

import com.shaunk.core.vo.R;
import com.shaunk.service.UserServiceI;
import com.shaunk.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Project sheep
 * @Package com.shaunk.web
 * @Name LoginController
 * @Version 1.0
 * @Data: 2019/6/28 3:28 PM
 * @Author: shaunk
 * @Description: 登录控制器
 */
@Slf4j
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserServiceI userService;


    @PostMapping("/login")
    public R login(@Valid @ModelAttribute LoginVo loginVo) throws Exception {

        return userService.login(loginVo);
    }

    @PostMapping("/userInfo")
    public R userInfo() throws Exception {

        return userService.getUser();
    }

    @PostMapping("/logout")
    public R logout() throws Exception {

        return userService.logout();
    }

}

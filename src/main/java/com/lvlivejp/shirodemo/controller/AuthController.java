package com.lvlivejp.shirodemo.controller;

import com.lvlivejp.shirodemo.base.BaseResult;
import com.lvlivejp.shirodemo.enums.ResultEnum;
import com.lvlivejp.shirodemo.model.TUser;
import com.lvlivejp.shirodemo.service.UserService;
import com.lvlivejp.shirodemo.utils.BaseResultUtils;
import com.lvlivejp.shirodemo.utils.ShiroThreadLocal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResult registerUser(TUser tUser) {
        return userService.save(tUser);
    }

    @GetMapping("/unLogin")
    public BaseResult unLogin(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return BaseResultUtils.fail(ResultEnum.UNLOGIN.getCode(), ResultEnum.UNLOGIN.getName());
    }

    @GetMapping("/unauthorized")
    public BaseResult unauthorized(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return BaseResultUtils.fail(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getName());
    }


    @PostMapping("/login")
    public BaseResult login(String username, String password, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        try {
            ShiroThreadLocal.setUserName(username);
            subject.login(token);
        }  finally {
            ShiroThreadLocal.removeUserName();
        }
        return BaseResultUtils.success();
    }

    @PostMapping("/logout")
    public BaseResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseResultUtils.success();
    }
}
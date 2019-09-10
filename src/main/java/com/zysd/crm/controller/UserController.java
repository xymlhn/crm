package com.zysd.crm.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zysd.crm.bean.ReturnT;
import com.zysd.crm.bean.User;
import com.zysd.crm.bean.UserVo;
import com.zysd.crm.service.UserService;
import com.zysd.crm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* 用户控制
* @author cartman 2019-05-06
*/
@Controller
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;
    /**
    * 新增
    */
    @PostMapping("/login")
    @ResponseBody
    public ReturnT<String> login(@RequestBody User user) {
        return userService.login(user.getUserName(),user.getPassword());
    }

    @GetMapping("/user")
    @ResponseBody
    public ReturnT<UserVo> login(HttpServletRequest request) {

        return new ReturnT<>((UserVo) request.getAttribute("user"));
    }
}

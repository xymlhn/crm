package com.zysd.crm.controller;

import com.zysd.crm.bean.RestResponse;
import com.zysd.crm.bean.User;
import com.zysd.crm.bean.UserVo;
import com.zysd.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
* 用户控制
* @author cartman 2019-05-06
*/
@Controller
@RequestMapping(value = "/crm")
public class UserController {

    @Autowired
    private UserService userService;
    /**
    * 登录
    */
    @PostMapping("/login")
    @ResponseBody
    public RestResponse<String> login(@Valid @RequestBody User user) {
        return RestResponse.success(userService.login(user.getUserName(),user.getPassword()));
    }

    @GetMapping("/user")
    @ResponseBody
    public RestResponse<UserVo> user(HttpServletRequest request) {

        return RestResponse.success((UserVo) request.getAttribute("user"));


    }
}

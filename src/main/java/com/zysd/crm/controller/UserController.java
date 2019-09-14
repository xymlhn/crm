package com.zysd.crm.controller;

import com.zysd.crm.bean.RestResponse;
import com.zysd.crm.bean.User;
import com.zysd.crm.bean.UserVo;
import com.zysd.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public RestResponse<String> login(@RequestBody User user) {
        return RestResponse.success(userService.login(user.getUserName(),user.getPassword()));
    }

    @GetMapping("/user")
    @ResponseBody
    public RestResponse<UserVo> user(HttpServletRequest request) {

        return RestResponse.success((UserVo) request.getAttribute("user"));


    }
}

package com.zysd.crm.controller;

import com.zysd.crm.base.BaseController;
import com.zysd.crm.domain.bean.RestResponse;
import com.zysd.crm.domain.bean.User;
import com.zysd.crm.domain.vo.UserVo;
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
public class UserController extends BaseController {

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
        return RestResponse.success(super.getCurrentUser());


    }
}

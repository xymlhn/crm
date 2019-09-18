package com.zysd.crm.controller;

import com.zysd.crm.base.BaseController;
import com.zysd.crm.base.RestResponse;
import com.zysd.crm.domain.entity.User;
import com.zysd.crm.domain.vo.UserVo;
import com.zysd.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 项目名称：CRM
 * 功能说明：用户控制器
 *
 * @author cartman
 * @createtime 2019/9/18 3:19 下午
 */
@Controller
@RequestMapping(value = "/crm")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return token字符串
     */
    @PostMapping("/login")
    @ResponseBody
    public RestResponse<String> login(@Valid @RequestBody User user) {
        return RestResponse.success(userService.login(user.getUserName(),user.getPassword()));
    }

    /**
     * 获取当前登录用户信息
     * @return 用户信息
     */
    @GetMapping("/user")
    @ResponseBody
    public RestResponse<UserVo> user() {
        return RestResponse.success(super.getCurrentUser());
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public RestResponse<String> logout() {
        userService.logout(getCurrentUser().getUser().getId());
        return RestResponse.success("");
    }
}

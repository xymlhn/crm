package com.zysd.crm.controller;

import com.alibaba.fastjson.JSON;
import com.zysd.crm.base.BaseController;
import com.zysd.crm.utils.OkHttpCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：CRM
 * 功能说明：kettle控制器
 *
 * @author cartman
 * @createtime 2019/9/18 3:19 下午
 */
@Controller
@RequestMapping(value = "/crm")
public class KettleController extends BaseController {

    @Autowired
    private OkHttpCli okHttpCli;

    @Value("${kettle.url}")
    private String kettleUrl;

    @GetMapping(value = "kettle")
    @ResponseBody
    public String show() {
        String url = kettleUrl + "?file=测试.ktr";
        Map<String,String> map = new HashMap<>();
        map.put("pageNum","0");
        map.put("pageSize","10");
        String message = okHttpCli.doPostJson(url, JSON.toJSONString(map));
        return message;
    }

}

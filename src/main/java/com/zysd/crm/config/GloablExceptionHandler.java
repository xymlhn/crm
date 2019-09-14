package com.zysd.crm.config;

import com.zysd.crm.bean.RestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *  @author cartman
 *  2019/0/05 上午11:33
 */
@ControllerAdvice
public class GloablExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResponse<String> handleException(Exception e) {
        // 记录错误信息
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return  RestResponse.fail(msg);
    }

    @ExceptionHandler(ZYException.class)
    @ResponseBody
    public RestResponse<String> handleException(ZYException e) {
        // 记录错误信息
        return  RestResponse.fail(e.getErrCode(),e.getMessage());
    }
}

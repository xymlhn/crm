package com.zysd.crm.config;

import com.zysd.crm.bean.ReturnT;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常处理
 *  @author cartman
 *  2019/0/05 上午11:33
 */
@ControllerAdvice
public class GloablExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReturnT<String> handleException(Exception e) {
        // 记录错误信息
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return new ReturnT<>(HttpStatus.BAD_REQUEST.value(),msg);
    }

}

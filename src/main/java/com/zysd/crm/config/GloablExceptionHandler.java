package com.zysd.crm.config;

import com.zysd.crm.domain.bean.RestResponse;
import com.zysd.crm.domain.enums.BaseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        if (msg == null || msg.equals(BaseEnum.NULL_STRING)) {
            msg = "服务器发生未知错误，请联系管理员";
        }
        return  RestResponse.fail(msg);
    }

    @ExceptionHandler(ZYException.class)
    @ResponseBody
    public RestResponse<String> handleException(ZYException e) {
        return  RestResponse.fail(e.getErrCode(),e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse<String> handleException(MethodArgumentNotValidException ex) {

        if(ex.getBindingResult().hasErrors()){
            return  RestResponse.fail(HttpStatus.BAD_REQUEST.value(),ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }
        return RestResponse.fail(ex.getMessage());
    }

}

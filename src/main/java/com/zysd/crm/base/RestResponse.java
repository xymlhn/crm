package com.zysd.crm.base;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 项目名称：CRM
 * 功能说明：前后端统一样式类
 *
 * @author cartman
 * @createtime 2019/9/18 3:19 下午
 */
@Data
public class RestResponse<T> implements Serializable {
    public static final long serialVersionUID = 42L;
    private Integer code;
    private String msg;
    private T data;

    public RestResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RestResponse<T> success(T data){
        return new RestResponse<>(HttpStatus.OK.value(), "", data);
    }
    public static RestResponse<String> fail(String message){
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }

    public static RestResponse<String> fail(Integer code,String message){
        return new RestResponse<>(code, message, null);
    }
}

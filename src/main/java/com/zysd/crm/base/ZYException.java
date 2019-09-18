package com.zysd.crm.base;


import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 项目名称：CRM
 * 功能说明：自定义异常
 *
 * @author cartman
 * @createtime 2019/9/18 3:19 下午
 */
@Data
public class ZYException extends RuntimeException {

    private Integer errCode = 0;

    public ZYException(Integer errCode,String msg){
        super(msg);
        this.errCode = errCode;
    }

    public ZYException(String msg) {
        super(msg);
        errCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }


    public static ZYException fail(String msg) {
        return new ZYException(msg);
    }
}

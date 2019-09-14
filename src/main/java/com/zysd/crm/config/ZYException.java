package com.zysd.crm.config;


import lombok.Data;

@Data
public class ZYException extends RuntimeException {

    private Integer errCode = 0;

    public ZYException(){

    }

    public ZYException(Integer errCode){
        this.errCode = errCode;
    }

    public ZYException(String msg) {
        super(msg);
    }

    public ZYException(Integer errCode, String msg){
        super(msg);
        this.errCode = errCode;
    }

    public static ZYException fail(String msg) {
        return new ZYException(msg);
    }
}

package com.zysd.crm.config;


import lombok.Data;

@Data
public class ZYException extends RuntimeException {

    private int errCode = 0;

    public ZYException(){

    }

    public ZYException(int errCode){
        this.errCode = errCode;
    }

    public ZYException(String msg) {
        super(msg);
    }

    public ZYException(int errCode, String msg){
        super(msg);
        this.errCode = errCode;
    }

    public ZYException(Throwable cause) {
        super(cause);
    }

    public ZYException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ZYException fail(String msg) {
        return new ZYException(msg);
    }
}

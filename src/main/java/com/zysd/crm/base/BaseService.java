package com.zysd.crm.base;

import org.springframework.aop.framework.AopContext;

public class BaseService<T> {
    public T getProxy(){
        return (T) AopContext.currentProxy();
    }
}

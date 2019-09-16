package com.zysd.crm.base;

import com.zysd.crm.domain.vo.UserVo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class BaseController {

    /**
     * 获取当前用户
     * @return UserVo
     */
    public UserVo getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        UserVo user = (UserVo)request.getAttribute(BaseEnum.USER_STRING);
        return user;
    }

}

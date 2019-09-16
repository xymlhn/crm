package com.zysd.crm.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zysd.crm.base.ZYException;
import com.zysd.crm.domain.vo.UserVo;
import com.zysd.crm.base.BaseEnum;
import com.zysd.crm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局拦截器
 * @author cartman
 * 2019/05/07 上午11:33
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Value("${jwt.token.expired}")
    private long expired;

    @Value("${jwt.secret.key}")
    private String secretKey;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {

        String authorization = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
        if (authorization == null) {
            throw new ZYException(HttpStatus.UNAUTHORIZED.value(),"未携带token");
        }

        if (!authorization.startsWith("Bearer ")){
            throw new ZYException(HttpStatus.UNAUTHORIZED.value(),"token格式错误");
        }
        String token = authorization.substring(7);

        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ZYException(HttpStatus.UNAUTHORIZED.value(),"token验证失败,请重新登录");
        }

        UserVo user = (UserVo) redisUtil.get(userId);
        if (user == null) {
            throw new ZYException(HttpStatus.UNAUTHORIZED.value(),"token已失效");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ZYException(HttpStatus.UNAUTHORIZED.value(),"token验证失败，请重新登录 ");
        }
        //刷新token过期时间
        redisUtil.expire(userId,expired);
        httpServletRequest.setAttribute(BaseEnum.USER_STRING,user);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}

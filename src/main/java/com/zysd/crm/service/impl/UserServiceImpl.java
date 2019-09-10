package com.zysd.crm.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zysd.crm.bean.*;
import com.zysd.crm.config.ZYException;
import com.zysd.crm.mapper.PasswordMapper;
import com.zysd.crm.mapper.RoleMapper;
import com.zysd.crm.mapper.UserMapper;
import com.zysd.crm.mapper.UserRoleMapper;
import com.zysd.crm.service.UserService;
import com.zysd.crm.utils.PasswordUtil;
import com.zysd.crm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    RedisUtil redisUtil;

    @Value("${jwt.token.expired}")
    private long expired;

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Autowired
    private PasswordMapper passwordMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ReturnT<String> login(String username, String password) {
        //根据用户名或者email查询用户列表
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.lambda().eq(User::getUserName, username).or().eq(User::getEmail,username);
        List<User> userList = userMapper.selectList(userWrapper);
        if (userList.size() == 0){
            throw new ZYException("用户名错误");
        }
        User user = userList.get(0);

        //根据用户id查询密码表中当前flag为N的列
        QueryWrapper<Password> passwordQueryWrapper = new QueryWrapper<>();
        passwordQueryWrapper.lambda().eq(Password::getUserId, user.getId()).eq(Password::getFlag,"Y");
        Password validPassword = passwordMapper.selectOne(passwordQueryWrapper);
        String pwd = PasswordUtil.encrypt(username, password, PasswordUtil.getStaticSalt());
        if(null == validPassword || !pwd.equals(validPassword.getPassword())){
            throw new ZYException("密码错误");
        }

        //查询用户角色列表

        List<Role> roles = roleMapper.listRole(user.getId());

        UserVo userVo = new UserVo();
        userVo.setUser(user);
        userVo.setRoleList(roles);

        //缓存用户信息进redis
        redisUtil.set(user.getId(),userVo,expired);
        //生成token
        String token = JWT.create().withAudience(user.getId())
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(secretKey));
        return new ReturnT<>(token);
    }
}

package com.zysd.crm.service;


public interface UserService{

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 登出
     * @param userId
     */
    void logout(String userId);
}

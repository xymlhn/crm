package com.zysd.crm.service;


public interface UserService{

    String login(String username, String password);

    void logout(String userId);
}

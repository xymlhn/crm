package com.zysd.crm.service;


import com.zysd.crm.bean.ReturnT;

public interface UserService {

    ReturnT<String> login(String username, String password);
}

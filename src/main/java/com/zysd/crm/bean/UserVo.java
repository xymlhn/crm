package com.zysd.crm.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserVo implements Serializable {
    private User user;
    private List<Role> roleList;
}

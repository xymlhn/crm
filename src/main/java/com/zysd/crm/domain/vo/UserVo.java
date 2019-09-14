package com.zysd.crm.domain.vo;

import com.zysd.crm.domain.bean.Role;
import com.zysd.crm.domain.bean.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserVo implements Serializable {
    private User user;
    private List<Role> roleList;
}

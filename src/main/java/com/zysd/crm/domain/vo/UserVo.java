package com.zysd.crm.domain.vo;

import com.zysd.crm.domain.entity.Role;
import com.zysd.crm.domain.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserVo implements Serializable {
    private User user;
    private List<Role> roleList;
}

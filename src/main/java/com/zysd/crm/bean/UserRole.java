package com.zysd.crm.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*  user_role
* @author cartman 2019-09-10
*/
@Data
@TableName(value = "t_org_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;

    /**
    * create_time
    */
    private Date createTime;

    /**
    * create_user_id
    */
    private String createUserId;

    /**
    * create_user_name
    */
    private String createUserName;

    /**
    * update_time
    */
    private Date updateTime;

    /**
    * update_user_id
    */
    private String updateUserId;

    /**
    * update_user_name
    */
    private String updateUserName;

    /**
    * role_id
    */
    private String roleId;

    /**
    * user_id
    */
    private String userId;

    public UserRole() {
    }

}

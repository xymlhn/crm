package com.zysd.crm.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "t_org_user_password")
public class Password implements Serializable {
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
    * flag
    */
    private String flag;

    /**
    * password
    */
    private String password;

    /**
    * update_password_time
    */
    private Date updatePasswordTime;

    /**
    * user_id
    */
    private String userId;

    public Password() {
    }

}

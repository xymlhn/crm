package com.zysd.crm.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_org_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;

    /**
    * name
    */
    private String name;

    /**
    * code
    */
    private String code;

    /**
    * description
    */
    private String description;

    /**
    * flag
    */
    private String flag;

    /**
    * allow_delete
    */
    private String allowDelete;

    /**
    * allow_edit
    */
    private String allowEdit;

    /**
    * create_user_id
    */
    private String createUserId;

    /**
    * create_user_name
    */
    private String createUserName;

    /**
    * create_time
    */
    private Date createTime;

    /**
    * update_user_id
    */
    private String updateUserId;

    /**
    * update_user_name
    */
    private String updateUserName;

    /**
    * update_time
    */
    private Date updateTime;

    /**
    * maintain_role_ids
    */
    private String maintainRoleIds;

    public Role() {
    }

}

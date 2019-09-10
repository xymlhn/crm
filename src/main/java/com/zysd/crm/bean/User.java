package com.zysd.crm.bean;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;

/**
 *  user
 * @author sie 2019-05-10
 */
@Data
@TableName(value = "t_org_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * user_name
     */
    private String userName;

    /**
     * password
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * user_type
     */
    private String userType;

    /**
     * user_type_id
     */
    private String userTypeId;

    /**
     * n:未删除，y已删除
     */
    private String flag;

    /**
     * n:未激活，y已激活
     */
    private String active;

    /**
     * n:未锁定，y已锁定
     */
    private String locked;

    /**
     * 登录次数
     */
    private Integer loginNum;

    /**
     * login_error_times
     */
    private Integer loginErrorTimes;

    /**
     * code
     */
    private String code;

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
     * description
     */
    private String description;

    /**
     * portrait_url
     */
    private String portraitUrl;

    /**
     * user_type_name
     */
    private String userTypeName;

    /**
     * app注册，0：未注册;1：已注册
     */
    private Integer isRegister;

    /**
     * gesture_password
     */
    private String gesturePassword;

    /**
     * 最近一次登录的设备
     */
    private String appDeviceId;

    /**
     * 自然年内切换设备的次数
     */
    private Integer changeAppDeviceTimes;

    public User() {
    }

}

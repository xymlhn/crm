package com.zysd.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zysd.crm.bean.UserRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*  user_role
* @author cartman 2019-09-10
*/
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {


}

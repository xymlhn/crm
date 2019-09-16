package com.zysd.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zysd.crm.domain.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT\n" +
            "\trole.* \n" +
            "FROM\n" +
            "\tt_org_role role\n" +
            "\tLEFT JOIN t_org_user_role user_role \n" +
            "\tON role.id = user_role.role_id\n" +
            "WHERE\n" +
            "\tuser_role.user_id = #{userId}")
    List<Role> listRole(String userId);

}

package com.zysd.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zysd.crm.domain.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    
}

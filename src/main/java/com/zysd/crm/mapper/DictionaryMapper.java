package com.zysd.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zysd.crm.domain.entity.Dictionary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：UCG
 * 功能说明：字典Mapper
 *
 * @author 夏伟耀
 * @createtime 2019/5/28 3:58 PM
 */
@Repository
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    /**
     * 功能说明：查询DEMO，实现分页和传入条件
     *
     * @param page 分页信息
     * @param parentCode 父级Code
     * @author 夏伟耀
     * @createtime 2019/5/28 5:38 PM
     */
    @Select("SELECT * FROM dictionary where parentCode = #{parentCode}")
    List<Dictionary> findByParentCode(Page page, @Param("parentCode") String parentCode);
}

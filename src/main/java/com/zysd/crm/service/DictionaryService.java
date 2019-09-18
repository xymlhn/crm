package com.zysd.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zysd.crm.base.FilterVo;
import com.zysd.crm.domain.entity.Dictionary;

public interface DictionaryService {

    /**
     * 分页查询字典
     * @param filterVo
     * @return
     */
    IPage<Dictionary> pageDictionary(FilterVo<Dictionary> filterVo);

    /**
     * 插入一个字典
     * @param dictionary
     * @return
     */
    Dictionary insert(Dictionary dictionary);

    /**
     * 更新一个字典
     * @param dictionary
     * @return
     */
    Dictionary update(Dictionary dictionary);
}

package com.zysd.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zysd.crm.base.FilterVo;
import com.zysd.crm.domain.entity.Dictionary;

public interface DictionaryService {

    IPage<Dictionary> pageDictionary(FilterVo<Dictionary> filterVo);

    Dictionary insert(Dictionary dictionary);

    Dictionary update(Dictionary dictionary);
}

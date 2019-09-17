package com.zysd.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zysd.crm.domain.entity.Dictionary;

public interface DictionaryService {

    IPage<Dictionary> list(Page page, Integer parentId);

    Dictionary insert(Dictionary dictionary);

    Dictionary update(Dictionary dictionary);
}

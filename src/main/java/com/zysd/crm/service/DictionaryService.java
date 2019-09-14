package com.zysd.crm.service;

import com.zysd.crm.domain.bean.Dictionary;

import java.util.List;

public interface DictionaryService {

    List<Dictionary> list(Integer parentId);

    Dictionary insert(Dictionary dictionary);

    Dictionary update(Dictionary dictionary);
}

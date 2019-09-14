package com.zysd.crm.service;

import com.zysd.crm.bean.Dictionary;

import java.util.List;

public interface DictionaryService {

    List<Dictionary> findDictTrees(String name);

    Dictionary insert(Dictionary dictionary);

    Dictionary update(Dictionary dictionary);
}

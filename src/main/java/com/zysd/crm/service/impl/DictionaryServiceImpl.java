package com.zysd.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zysd.crm.base.FilterVo;
import com.zysd.crm.base.ZYException;
import com.zysd.crm.domain.entity.Dictionary;
import com.zysd.crm.mapper.DictionaryMapper;
import com.zysd.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictMapper;

    @Override
    public IPage<Dictionary> pageDictionary(FilterVo<Dictionary> filterVo) {
        Dictionary dictionary = filterVo.getFilter();
        dictionary.setParentId(dictionary.getParentId() == null ? Dictionary.ROOT:dictionary.getParentId());
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(dictionary);
        queryWrapper.orderBy(filterVo.hasOrder(), filterVo.isAsc(), filterVo.getOrderBy());
        return dictMapper.selectPage(filterVo.getPage(),queryWrapper);
    }

    @Override
    public Dictionary insert(Dictionary dictionary) {
        oneDictionary(dictionary);
        dictMapper.insert(dictionary);
        return dictionary;
    }

    @Override
    public Dictionary update(Dictionary dictionary) {
        if (dictionary.getId() == null){
            throw new ZYException("id为空无法更新字典");
        }
        oneDictionary(dictionary);
        dictMapper.updateById(dictionary);
        return dictionary;
    }


    /**
     * 字典检查是否同code值，parentId是否合法
     * @param dictionary
     */
    private void oneDictionary(Dictionary dictionary) {

        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Dictionary::getCode, dictionary.getCode())
                .eq(Dictionary::getParentId, dictionary.getParentId());
        Dictionary tempDict = dictMapper.selectOne(queryWrapper);
        if (tempDict != null && !tempDict.getId().equals(dictionary.getId())){
            throw new ZYException("在同一层级parentId:" + dictionary.getParentId() +"不能同时存在一样的code");
        }

        if(!dictionary.getParentId().equals(Dictionary.ROOT)){
            QueryWrapper<Dictionary> dictionaryQueryWrapper = new QueryWrapper<>();
            dictionaryQueryWrapper.lambda().eq(Dictionary::getId, dictionary.getParentId());
            Dictionary dict = dictMapper.selectOne(dictionaryQueryWrapper);
            if (dict == null){
                throw new ZYException("字典parentId:" + dictionary.getParentId() +"不合法");
            }
        }

    }

}

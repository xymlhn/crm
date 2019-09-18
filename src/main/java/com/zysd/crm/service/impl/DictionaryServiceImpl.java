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

import java.util.ArrayList;
import java.util.List;

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
        oneDictionary(dictionary);
        dictMapper.updateById(dictionary);
        return dictionary;
    }

    private void oneDictionary(Dictionary dictionary) {
        if(!dictionary.getParentId().equals(Dictionary.ROOT)){
            QueryWrapper<Dictionary> dictionaryQueryWrapper = new QueryWrapper<>();
            dictionaryQueryWrapper.lambda().eq(Dictionary::getId, dictionary.getParentId());
            Dictionary dict = dictMapper.selectOne(dictionaryQueryWrapper);
            if (dict == null){
                throw new ZYException("字典parentId:" + dictionary.getParentId() +"不合法");
            }
        }

    }

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private List<Dictionary> getChild(Integer id,List<Dictionary> allMenu){
        //子菜单
        List<Dictionary> childList = new ArrayList<>();
        for (Dictionary nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(nav.getParentId().equals(id)){
                childList.add(nav);
            }
        }
        //递归
        for (Dictionary nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.isEmpty()){
            return new ArrayList<>();
        }
        return childList;
    }

}

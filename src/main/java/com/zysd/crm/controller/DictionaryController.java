package com.zysd.crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zysd.crm.base.BaseController;
import com.zysd.crm.base.FilterVo;
import com.zysd.crm.base.RestResponse;
import com.zysd.crm.domain.entity.Dictionary;
import com.zysd.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * 项目名称：CRM
 * 功能说明：字典控制器
 *
 * @author cartman
 * @createtime 2019/9/18 3:19 下午
 */
@RestController
@RequestMapping("crm")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 功能说明：查找字典分页
     *
     * @author cartman
     * @createtime 2019/8/13 10:07 AM
     * @return 字典分页
     */
    @PostMapping("pageDictionary")
    public RestResponse<IPage<Dictionary>> list(@RequestBody FilterVo<Dictionary> filterVo) {

        return RestResponse.success(dictionaryService.pageDictionary(filterVo));
    }

    /**
     * 插入字典
     * @param dictionary
     * @return
     */
    @PostMapping("dictionary")
    public RestResponse<Dictionary> insert(@Valid @RequestBody Dictionary dictionary) {
        dictionary.setCreateTime(new Date());
        dictionary.setUpdateTime(new Date());
        dictionary.setCreateUser(getCurrentUser().getUser().getUserName());
        dictionary.setUpdateUser(getCurrentUser().getUser().getUserName());
        return RestResponse.success(dictionaryService.insert(dictionary));
    }

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    @PutMapping("dictionary")
    public RestResponse<Dictionary> update(@Valid @RequestBody Dictionary dictionary) {
        dictionary.setUpdateTime(new Date());
        dictionary.setUpdateUser(getCurrentUser().getUser().getUserName());
        return RestResponse.success(dictionaryService.update(dictionary));
    }
}

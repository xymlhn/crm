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
 * 项目名称：UCG
 * 功能说明：字典Controller
 *
 * @author 夏伟耀
 * @createtime 2019/5/28 6:02 PM
 */
@RestController
@RequestMapping("crm")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 功能说明：查找字典树
     *
     * @author
     * @createtime 2019/8/13 10:07 AM
     * @return
     */
    @PostMapping("pageDictionary")
    public RestResponse<IPage<Dictionary>> list(@RequestBody FilterVo<Dictionary> filterVo) {

        return RestResponse.success(dictionaryService.pageDictionary(filterVo));
    }

    @PostMapping("dictionary")
    public RestResponse<Dictionary> insert(@Valid @RequestBody Dictionary dictionary) {
        dictionary.setCreateTime(new Date());
        dictionary.setUpdateTime(new Date());
        dictionary.setCreateUser(getCurrentUser().getUser().getUserName());
        dictionary.setUpdateUser(getCurrentUser().getUser().getUserName());
        return RestResponse.success(dictionaryService.insert(dictionary));
    }

    @PutMapping("dictionary")
    public RestResponse<Dictionary> update(@Valid @RequestBody Dictionary dictionary) {
        dictionary.setUpdateTime(new Date());
        dictionary.setUpdateUser(getCurrentUser().getUser().getUserName());
        return RestResponse.success(dictionaryService.update(dictionary));
    }
}

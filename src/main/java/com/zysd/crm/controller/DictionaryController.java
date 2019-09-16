package com.zysd.crm.controller;

import com.zysd.crm.base.BaseController;
import com.zysd.crm.domain.entity.Dictionary;
import com.zysd.crm.base.RestResponse;
import com.zysd.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
     * @author 梁煜圣
     * @createtime 2019/8/13 10:07 AM
     * @return
     */
    @GetMapping("dictionary")
    public RestResponse<List<Dictionary>> list(@RequestParam(required = false) Integer parentId) {
        parentId = parentId == null ? Dictionary.ROOT:parentId;
        return RestResponse.success(dictionaryService.list(parentId));
    }

    @PostMapping("dictionary")
    public RestResponse<Dictionary> insert(@Valid @RequestBody Dictionary dictionary) {
        return RestResponse.success(dictionaryService.insert(dictionary));
    }

    @PutMapping("dictionary")
    public RestResponse<Dictionary> update(@Valid Dictionary dictionary) {
        return RestResponse.success(dictionaryService.update(dictionary));
    }
}

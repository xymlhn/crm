package com.zysd.crm.controller;

import com.zysd.crm.bean.Dictionary;
import com.zysd.crm.bean.RestResponse;
import com.zysd.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名称：UCG
 * 功能说明：字典Controller
 *
 * @author 夏伟耀
 * @createtime 2019/5/28 6:02 PM
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 功能说明：查找字典树
     *
     * @author 梁煜圣
     * @createtime 2019/8/13 10:07 AM
     * @return
     */
    @GetMapping("trees")
    public RestResponse<List<Dictionary>> listTrees(@RequestParam(required = false) String name) {

        return RestResponse.success(dictionaryService.findDictTrees(name));
    }

    @PostMapping("insert")
    public RestResponse<Dictionary> insert(@RequestBody Dictionary dictionary) {

        return RestResponse.success(dictionaryService.insert(dictionary));
    }

    @PutMapping("update")
    public RestResponse<Dictionary> update(@RequestBody Dictionary dictionary) {
        return RestResponse.success(dictionaryService.update(dictionary));
    }
}

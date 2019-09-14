package com.zysd.crm.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "dictionary")
public class Dictionary{

    public final static Integer ROOT = 0;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父级Code
     */
    private Integer parentId;

    /**
     * 字典Code
     */
    private String code;

    /**
     * 字典Name
     */
    private String name;

    /**
     * 字典描述
     */
    private String description;

    // 树菜单
    @TableField(exist = false)
    private List<Dictionary> children;

    /**
     * 是否可用
     */
    private Integer enable;
}

package com.zysd.crm.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
    @NotBlank(message="code不能为空！")
    @Length(max=32,message="code长度不能超过10")
    private String code;

    /**
     * 字典Name
     */
    @NotBlank(message="name不能为空！")
    @Length(max=32,message="name长度不能超过32")
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

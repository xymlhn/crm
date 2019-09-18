package com.zysd.crm.base;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 项目名称：UCG
 * 功能说明：分页和排序配置
 *
 * @author 夏伟耀
 * @createtime 2019/6/11 6:24 PM
 */
@Data
public class FilterVo<T> {

    public static final char UNDERLINE = '_';

    /** 过滤条件 */
    private T filter;

    /** 页码 */
    private Integer page;

    /** 行数 */
    private Integer rows;

    /** 排序字段 */
    private String orderBy;

    /** 排序方式 */
    private String orderType;

    /**
     * 功能说明：返回页码，若空返回1
     *
     * @author 夏伟耀
     * @createtime 2019/6/14 11:33 AM
     */
    public Integer getNotNullPage() {
        return page == null ? 1 : page;
    }

    /**
     * 功能说明：返回行数，若空返回10
     *
     * @author 夏伟耀
     * @createtime 2019/6/14 11:33 AM
     */
    public Integer getNotNullRows() {
        return rows == null ? 10 : rows;
    }

    /**
     * 功能说明：获取排序，已将驼峰字段格式化成下划线
     *
     * @author 夏伟耀
     * @createtime 2019/6/14 11:33 AM
     */
    public String getOrderBy() {
        return this.upToUnderline(orderBy);
    }

    /**
     * 功能说明：是否有排序
     *
     * @author 夏伟耀
     * @createtime 2019/6/14 11:33 AM
     */
    public Boolean hasOrder() {
        return StringUtils.isNotEmpty(orderBy);
    }

    /**
     * 功能说明：是否为正序排序
     *
     * @author 夏伟耀
     * @createtime 2019/6/14 11:33 AM
     */
    public Boolean isAsc() {
        return !"desc".equalsIgnoreCase(orderType);
    }

    public Page<T> getPage(){
        Page<T> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(rows);
        return page1;
    }


    private String upToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

package com.api.gen.entity;

import lombok.Data;

/**
 * 表字段
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@Data
public class TableColumns {
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 字段备注
     */
    private String columnComment;
    private String columnKey;
    private String extra;
}

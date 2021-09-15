package com.potato.datasource.entity;

import lombok.Data;

/**
 * 数据源
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@Data
public class BaseDatasource {
    /**
     * 主键
     */
    private Long datasourceId;

    /**
     * 数据库名称
     */
    private String datasourceName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库url
     */
    private String url;
}

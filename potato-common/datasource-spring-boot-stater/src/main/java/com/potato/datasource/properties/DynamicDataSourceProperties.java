package com.potato.datasource.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 动态数据源配置
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@ConfigurationProperties(prefix = "potato.datasource")
@Data
public class DynamicDataSourceProperties {
    /**
     * 是否默认加载
     */
    public boolean autoInit = true;

    /**
     * 是否开始行模式
     */
    public boolean row = true;
}

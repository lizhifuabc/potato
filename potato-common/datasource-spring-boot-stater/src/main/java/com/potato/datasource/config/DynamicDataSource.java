package com.potato.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态数据源
 *
 * @author lizhifu
 * @date 2021/9/8
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 缓存动态数据源
     */
    private ConcurrentHashMap<Object, Object> targetDataSources = new ConcurrentHashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DynamicDataSourceContextHolder.getDataSource();
        return dataSource;
    }
    public DynamicDataSource(DataSource defaultTargetDataSource) {
        // 设置默认数据源
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        // 设置数据源
        super.setTargetDataSources(targetDataSources);
    }
    public synchronized void setDataSource(String key, DataSource datasource) {
        if (targetDataSources.containsKey(key)) {
            return;
        }
        targetDataSources.put(key, datasource);
        // 重新初始化AbstractRoutingDataSource 中的 resolvedDataSources
        super.afterPropertiesSet();
    }
}

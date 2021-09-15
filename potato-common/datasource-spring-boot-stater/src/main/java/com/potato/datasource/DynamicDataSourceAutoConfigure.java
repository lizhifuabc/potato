package com.potato.datasource;

import com.potato.datasource.config.DynamicDataSource;
import com.potato.datasource.entity.BaseDatasource;
import com.potato.datasource.mapper.BaseDatasourceMapper;
import com.potato.datasource.properties.DynamicDataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动态数据源装配
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@Slf4j
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceAutoConfigure {
    @Resource
    private DynamicDataSourceProperties dynamicDataSourceProperties;
    @Resource
    private DynamicDataSource dynamicDataSource;

    @Resource
    private BaseDatasourceMapper baseDatasourceMapper;

    @Resource(name = "master")
    private HikariDataSource master;
    @Bean
    public void initDynamicDataSource() {
        log.info("初始化动态数据源，配置数据为{}",dynamicDataSourceProperties);
        if(dynamicDataSourceProperties.isAutoInit()){
            List<BaseDatasource> list = baseDatasourceMapper.select();
            list.forEach(res->{
                log.info("新增数据源{}",res);
                HikariDataSource dataSource = new HikariDataSource();
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dataSource.setJdbcUrl(res.getUrl());
                dataSource.setUsername(res.getUserName());
                dataSource.setPassword(res.getPassword());
                dataSource.setDataSourceProperties(master.getDataSourceProperties());
                dynamicDataSource.setDataSource(res.getDatasourceId().toString(),dataSource);
            });
        }
    }
}

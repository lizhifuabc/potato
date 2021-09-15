package com.datasource.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * test
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.datasource.test.mapper"})
public class DataSourceTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSourceTestApplication.class, args);
    }
}

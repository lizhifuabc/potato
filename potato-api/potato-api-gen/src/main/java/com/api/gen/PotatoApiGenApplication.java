package com.api.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成模块
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.api.gen.mapper"})
public class PotatoApiGenApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(PotatoApiGenApplication.class, args);
    }
}

package com.api.gen;

import com.potato.feign.annotation.EnablePotatoFeignClients;
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
@EnablePotatoFeignClients(basePackages = {"com.api"})
public class PotatoApiGenApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(PotatoApiGenApplication.class, args);
    }
}

package com.potato.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 系统模块
 * 
 * @author lizhifu
 */
@EnableFeignClients(basePackages = "com.potato")
// 开启线程异步执行
@EnableAsync
@SpringBootApplication
public class PotatoSysApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PotatoSysApplication.class, args);
    }
}

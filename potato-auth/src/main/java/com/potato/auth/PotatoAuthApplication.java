package com.potato.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 授权认证中心
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.potato")
@EnableDiscoveryClient
public class PotatoAuthApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(PotatoAuthApplication.class, args);
    }
}

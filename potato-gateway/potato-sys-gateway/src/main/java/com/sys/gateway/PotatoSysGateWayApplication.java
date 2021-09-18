package com.sys.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关服务
 *
 * @author lizhifu
 * @date 2021/9/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PotatoSysGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PotatoSysGateWayApplication.class, args);
    }
}

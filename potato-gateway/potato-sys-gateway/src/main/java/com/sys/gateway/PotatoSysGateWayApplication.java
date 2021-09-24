package com.sys.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关服务
 * 网关没有数据库服务((exclude = {DataSourceAutoConfiguration.class }))
 * @author lizhifu
 * @date 2021/9/18
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PotatoSysGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PotatoSysGateWayApplication.class, args);
    }
}

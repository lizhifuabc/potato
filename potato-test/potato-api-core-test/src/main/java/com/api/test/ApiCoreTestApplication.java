package com.api.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * test
 * http://localhost:8080/demo/v1.0/?i=1
 * @author lizhifu
 * @date 2021/9/8
 */
@SpringBootApplication(scanBasePackages = {"com.potato.core","com.api.test"})
public class ApiCoreTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiCoreTestApplication.class, args);
    }
}

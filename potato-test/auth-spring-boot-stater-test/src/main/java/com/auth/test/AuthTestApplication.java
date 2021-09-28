package com.auth.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * test
 *
 * @author lizhifu
 * @date 2021/9/8
 */
@SpringBootApplication(scanBasePackages = {"com.potato.auth","com.auth.test"})
public class AuthTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthTestApplication.class, args);
    }
}

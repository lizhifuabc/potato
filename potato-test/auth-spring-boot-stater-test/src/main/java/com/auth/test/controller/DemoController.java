package com.auth.test.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * demo
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@RestController("demo")
public class DemoController {
    public String demo(){
        return UUID.randomUUID().toString();
    }
}

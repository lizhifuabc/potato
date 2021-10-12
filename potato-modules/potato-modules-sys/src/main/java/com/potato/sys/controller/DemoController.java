package com.potato.sys.controller;

import com.commom.core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * demo
 *
 * @author lizhifu
 * @date 2021/9/29
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    /**
     * 获取当前用户信息
     */
    @GetMapping("/demo")
    public R<String> demo()
    {
        return new R<>().success(UUID.randomUUID().toString());
    }
}

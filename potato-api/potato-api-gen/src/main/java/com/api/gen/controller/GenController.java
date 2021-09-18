package com.api.gen.controller;

import com.potato.core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成
 *
 * @author lizhifu
 * @date 2021/9/18
 */
@RequestMapping("/gen")
@RestController
public class GenController {
    @GetMapping("/list")
    public R genList()
    {
        return new R().success();
    }
}

package com.potato.sys.controller;

import com.commom.core.base.R;
import com.potato.api.sys.model.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author lizhifu
 * @date 2021/9/29
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    /**
     * 获取当前用户信息
     */
    @GetMapping("/info/{username}")
    public R<LoginUser> info(@PathVariable("username") String username)
    {
        System.out.println("获取当前用户信息");
        return new R<>().success(username);
    }
}

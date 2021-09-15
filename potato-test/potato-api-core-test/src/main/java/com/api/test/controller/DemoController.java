package com.api.test.controller;

import com.potato.core.annotation.ApiVersion;
import com.potato.core.base.R;
import com.potato.core.base.ReturnCode;
import com.potato.core.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 * http://localhost:8080/demo/demo
 *
 * @author lizhifu
 * @date 2021/9/15
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {
    @RequestMapping("/demo")
    public R<String> demo(){
        return new R().success();
    }

    @ApiVersion
    @GetMapping(value = "{version}/")
    public String index(int i){
        if(i >= 10){
            throw new CustomException(ReturnCode.SYSTEM_ERROR.getCode(),ReturnCode.SYSTEM_ERROR.getMsg());
        }
        return "index";
    }

    @ApiVersion(value = 2)
    @GetMapping(value = "{version}/")
    public String index2(int i){
        if(i >= 10){
            throw new CustomException(ReturnCode.SYSTEM_ERROR.getCode(),ReturnCode.SYSTEM_ERROR.getMsg());
        }
        return "index2";
    }
}

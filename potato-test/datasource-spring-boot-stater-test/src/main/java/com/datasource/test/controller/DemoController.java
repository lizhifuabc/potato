package com.datasource.test.controller;

import com.datasource.test.component.TableComponent;
import com.datasource.test.entity.Table;
import com.datasource.test.mapper.TableMapper;
import com.potato.datasource.annotation.DynamicAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * demo
 *
 * @author lizhifu
 * @date 2021/9/13
 */
@RestController
@Slf4j
public class DemoController {
    @Resource
    private TableMapper tableMapper;
    @Resource
    private TableComponent tableComponent;

    @RequestMapping("/demo")
    @DynamicAnnotation
    public List<Table> demo(String tenantId,int value){
        List<Table> tables =  tableMapper.select();
        tables.forEach(res->{
            log.info(res.toString());
        });
        tableComponent.trans(value);
        return tables;
    }
}

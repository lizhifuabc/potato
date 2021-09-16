package com.api.gen;

import com.api.gen.mapper.GeneratorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * GeneratorMapper测试
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@SpringBootTest
public class GeneratorMapperTest {
    @Resource
    private GeneratorMapper generatorMapper;
    @Test
    public void selectColumns(){
        generatorMapper.selectColumns("base_datasource");
    }
}

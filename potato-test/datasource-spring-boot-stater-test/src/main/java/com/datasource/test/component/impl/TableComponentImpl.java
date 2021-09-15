package com.datasource.test.component.impl;

import com.datasource.test.component.TableComponent;
import com.datasource.test.mapper.TableMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * TableComponent
 *
 * @author lizhifu
 * @date 2021/9/13
 */
@Component
public class TableComponentImpl implements TableComponent {
    @Resource
    private TableMapper tableMapper;
    @Override
    @Transactional(propagation= Propagation.REQUIRED ,rollbackFor=Exception.class)
    public void trans(int value) {
        tableMapper.insert(UUID.randomUUID().toString().replace("-",""));
        if(value == 1){
            throw new RuntimeException("事务测试");
        }
        tableMapper.insert(UUID.randomUUID().toString().replace("-",""));
    }
}

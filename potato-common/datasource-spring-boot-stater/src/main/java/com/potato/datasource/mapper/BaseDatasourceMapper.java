package com.potato.datasource.mapper;

import com.potato.datasource.entity.BaseDatasource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 数据源mapper
 *
 * @author lizhifu
 * @date 2021/9/8
 */
public interface BaseDatasourceMapper {
    /**
     * 获取所有的数据源配置
     */
    @Select("select * from base_datasource")
    List<BaseDatasource> select();
}

package com.datasource.test.mapper;

import com.datasource.test.entity.Table;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * table
 *
 * @author lizhifu
 * @date 2021/9/13
 */
public interface TableMapper {
    @Select("select * from table01")
    public List<Table> select();

    @Select("INSERT INTO table01 (value) VALUES (#{value})")
    public void insert(String value);
}

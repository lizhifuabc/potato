package com.api.gen.mapper;

import com.api.gen.entity.TableColumns;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库基本查询
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@Component
@Mapper
public interface GeneratorMapper {
    /**
     * 根据表名查询字段
     * @param tableName 表名
     * @return 字段信息
     */
    List<TableColumns> selectColumns(String tableName);
}

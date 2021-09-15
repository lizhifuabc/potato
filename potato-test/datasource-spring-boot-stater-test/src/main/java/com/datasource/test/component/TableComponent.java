package com.datasource.test.component;

/**
 * TableComponent
 *
 * @author lizhifu
 * @date 2021/9/13
 */
public interface TableComponent {
    /**
     * 事务测试
     * @param value 事务触发条件
     */
    public void trans(int value);
}

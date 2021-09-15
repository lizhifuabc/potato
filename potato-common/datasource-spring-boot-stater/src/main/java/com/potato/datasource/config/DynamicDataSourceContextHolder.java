package com.potato.datasource.config;

/**
 * 动态数据源上下文
 *
 * @author lizhifu
 * @date 2021/9/8
 */
public class DynamicDataSourceContextHolder {
    /**
     * 当前线程数据源的key
     */
    private static final ThreadLocal<String> CURRENT_DATASOURCE_HOLDER = new ThreadLocal<String>();

    /**
     * 切换数据源
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        CURRENT_DATASOURCE_HOLDER.set(dataSource);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSource() {
        return CURRENT_DATASOURCE_HOLDER.get();
    }

    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        CURRENT_DATASOURCE_HOLDER.remove();
    }
}

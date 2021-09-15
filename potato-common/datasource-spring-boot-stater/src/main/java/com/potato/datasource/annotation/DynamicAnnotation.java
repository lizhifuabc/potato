package com.potato.datasource.annotation;

import java.lang.annotation.*;

/**
 * 动态数据源注解
 *
 * @author lizhifu
 * @date 2021/9/13
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicAnnotation {
}

package com.potato.core.annotation;

import java.lang.annotation.*;

/**
 * 接口版本控制
 *
 * @author lizhifu
 * @date 2021/9/14
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    /**
     * 版本
     * @return 默认版本
     */
    double value() default 1;
}

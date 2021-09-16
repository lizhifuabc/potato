package com.api.gen.properties;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 代码生成配置文件
 *
 * @author lizhifu
 * @date 2021/9/16
 */
@Component
@PropertySource("classpath:generator.properties")
@Data
public class GeneratorProperties {

}

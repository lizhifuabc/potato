package com.potato.auth;

import com.potato.auth.properties.SecurityProperties;
import com.potato.auth.properties.TokenStoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * auth 自动装配
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@EnableConfigurationProperties({SecurityProperties.class,TokenStoreProperties.class})
@ComponentScan
public class AuthAutoConfig {
}

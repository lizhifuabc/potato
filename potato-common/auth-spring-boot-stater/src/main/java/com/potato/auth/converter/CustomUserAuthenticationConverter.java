package com.potato.auth.converter;

import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

/**
 * 自定义转换
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@Component
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
}

package com.potato.auth.component;

import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

/**
 * 自定义TokenServices
 *
 * @author lizhifu
 * @date 2021/9/24
 */
public class CustomTokenServices extends DefaultTokenServices {
    /**
     * 同应用同账号互踢
     */
    private boolean isSingleLogin;

    public CustomTokenServices(boolean isSingleLogin) {
        this.isSingleLogin = isSingleLogin;
    }
}

package com.potato.auth.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 租户-用户名密码授权模式
 *
 * @author lizhifu
 * @date 2021/9/24
 */
public class TenantUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    /**
     * 租户标识
     */
    private final String clientId;

    public TenantUsernamePasswordAuthenticationToken(Object principal, Object credentials, String clientId) {
        super(principal, credentials);
        this.clientId = clientId;
    }

    public TenantUsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String clientId) {
        super(principal, credentials, authorities);
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }
}

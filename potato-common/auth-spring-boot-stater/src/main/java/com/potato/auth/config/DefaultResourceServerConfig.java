package com.potato.auth.config;

import com.potato.auth.properties.SecurityProperties;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;

/**
 * 资源服务器配置
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@Import(DefaultSecurityHandlerConfig.class)
public class DefaultResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Resource
    private SecurityProperties securityProperties;
    @Resource
    private TokenStore tokenStore;
    @Resource
    private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    /**
     * http安全配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl = http
                .authorizeRequests()
                .antMatchers(securityProperties.getUrls()).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest();

        authorizedUrl.authenticated().and();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .httpBasic().disable()
                .headers()
                // 允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
                .frameOptions().disable()
                .and()
                // 关闭跨站请求
                .csrf().disable();
    }

    /**
     * 资源安全配置
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                // 令牌服务
                .tokenStore(tokenStore)
                .stateless(true)
                // 认证异常流程处理返回-未授权
                .authenticationEntryPoint(authenticationEntryPoint)
                // 无权限处理
                .accessDeniedHandler(oAuth2AccessDeniedHandler);
    }
}

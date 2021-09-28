package com.potato.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * OAuth2 授权服务器
 *
 * @author lizhifu
 * @date 2021/9/24
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * redis客户端配置
     */
    @Resource(name = "redisClientDetailsService")
    private ClientDetailsService clientDetailsService;

    @Resource
    private TokenStore tokenStore;
    /**
     * 密码模式下配置认证管理器 AuthenticationManager
     */
    @Resource
    private AuthenticationManager authenticationManager;
    /**
     * 认证错误处理
     */
    @Resource
    private WebResponseExceptionTranslator webResponseExceptionTranslator;
    /**
     * 授权码
     */
    @Resource
    private RandomValueAuthorizationCodeServices authorizationCodeServices;
    /**
     * 授权模式
     */
    @Resource
    private TokenGranter tokenGranter;
    /**
     * 访问端点配置:装载Endpoints所有相关的类配置（AuthorizationServer、TokenServices、TokenStore、ClientDetailsService、UserDetailsService）
     * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                // 支持 get post 请求
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .tokenStore(tokenStore)
                // 密码模式下配置认证管理器 AuthenticationManager
                .authenticationManager(authenticationManager)
                // .userDetailsService(userDetailsServiceFactory.getService(SecurityConstants.DEF_ACCOUNT_TYPE))
                // 授权码
                .authorizationCodeServices(authorizationCodeServices)
                // 认证错误处理
                .exceptionTranslator(webResponseExceptionTranslator)
                // 授权模式
                .tokenGranter(tokenGranter);
    }
    /**
     * 访问安全配置：用来配置令牌端点（Token Endpoint）的安全与权限访问
     * 默认过滤器：BasicAuthenticationFilter
     * 1、oauth_client_details表中clientSecret字段加密【ClientDetails属性secret】
     * 2、CheckEndpoint类的接口 oauth/check_token 无需经过过滤器过滤，默认值：denyAll()
     * 对以下的几个端点进行权限配置：
     * /oauth/authorize：授权端点
     * /oauth/token：令牌端点
     * /oauth/confirm_access：用户确认授权提交端点
     * /oauth/error：授权服务错误信息端点
     * /oauth/check_token：用于资源服务访问的令牌解析端点
     * /oauth/token_key：提供公有密匙的端点，如果使用JWT令牌的话
     * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                //让/oauth/token支持client_id以及client_secret作登录认证
                .allowFormAuthenticationForClients();
    }
    /**
     * 配置应用名称 应用id
     * 配置OAuth2的客户端相关信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }
}

package com.potato.auth.config;

import com.commom.core.base.R;
import com.commom.core.base.ReturnCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * ResourceServerConfigurerAdapter
 *
 * @author lizhifu
 * @date 2021/9/23
 */
public class DefaultSecurityHandlerConfig {
    @Resource
    private ObjectMapper objectMapper;
    /**
     * 未登录，返回401
     *
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> responseWrite(objectMapper,response,new R().error(authException.getMessage(), ReturnCode.UNAUTHORIZED.getCode()));
    }
    /**
     * 授权失败
     */
    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
                responseWrite(objectMapper,response,new R().error(authException.getMessage(), ReturnCode.SYSTEM_ERROR.getCode()));
            }
        };
    }
    private static void responseWrite(ObjectMapper objectMapper, HttpServletResponse response, R result) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (
                Writer writer = response.getWriter()
        ) {
            writer.write(objectMapper.writeValueAsString(result));
            writer.flush();
        }
    }
}

package com.potato.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全配置
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@ConfigurationProperties(prefix = "potato.security")
@RefreshScope
@Data
public class SecurityProperties {
    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {
            "/oauth/**",
            "/actuator/**",
    };

    /**
     * 设置不用认证的url
     */
    private String[] ignoreUrls = {};

    public String[] getUrls() {
        if (ignoreUrls == null || ignoreUrls.length == 0) {
            return ENDPOINTS;
        }
        List<String> list = new ArrayList<>();
        for (String url : ENDPOINTS) {
            list.add(url);
        }
        for (String url : ignoreUrls) {
            list.add(url);
        }
        return list.toArray(new String[list.size()]);
    }
}

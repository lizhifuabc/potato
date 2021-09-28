package com.potato.auth.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * redis优化缓存配置
 *
 * @author lizhifu
 * @date 2021/9/27
 */
@Slf4j
@Service(value = "redisClientDetailsService")
public class RedisClientDetailsService extends JdbcClientDetailsService {
    /**
     * oauth 客户端信息
     */
    private static final String CLIENT_DETAIL_KEY = "potato:auth:client:details";

    public RedisClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    @SneakyThrows
    @Cacheable(value = CLIENT_DETAIL_KEY, key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }
}

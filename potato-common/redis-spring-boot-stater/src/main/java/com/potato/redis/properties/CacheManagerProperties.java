package com.potato.redis.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 自定义cache manager
 *
 * @author lizhifu
 * @date 2021/9/28
 */
@Data
@ConfigurationProperties(prefix = "potato.cache-manager")
public class CacheManagerProperties {
    private List<CacheConfig> configs;

    @Data
    public static class CacheConfig {
        /**
         * key
         */
        private String key;
        /**
         * 过期时间,单位秒
         */
        private long second = 60;
    }
}

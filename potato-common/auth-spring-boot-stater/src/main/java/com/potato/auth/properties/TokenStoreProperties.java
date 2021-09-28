package com.potato.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * token配置
 *
 * @author lizhifu
 * @date 2021/9/23
 */
@Data
@ConfigurationProperties(prefix = "potato.auth.token.store")
//@RefreshScope
public class TokenStoreProperties {
    /**
     * token存储类型(jwt)
     */
    private String type = "jwt";
}

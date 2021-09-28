package com.potato.auth.component;

import com.potato.redis.service.RedisService;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 授权码
 *
 * @author lizhifu
 * @date 2021/9/24
 */
@Component
public class RedisRandomValueAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {
    private final RedisService redisService;
    private final RedisSerializer<Object> valueSerializer;

    public RedisRandomValueAuthorizationCodeServices(RedisService redisService) {
        this.redisService = redisService;
        this.valueSerializer = RedisSerializer.java();
    }
    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        redisService.setExpire(redisKey(code), authentication, 10, TimeUnit.MINUTES, valueSerializer);
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        String codeKey = redisKey(code);
        OAuth2Authentication token = (OAuth2Authentication) redisService.get(codeKey, valueSerializer);
        redisService.del(codeKey);
        return token;
    }

    /**
     * redis oauth key
     * @param code
     * @return
     */
    private String redisKey(String code) {
        return "potato:oauth:code:" + code;
    }
}

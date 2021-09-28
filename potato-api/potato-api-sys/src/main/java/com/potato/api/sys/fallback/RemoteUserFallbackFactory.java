package com.potato.api.sys.fallback;

import com.commom.core.base.R;
import com.potato.api.sys.RemoteUserService;
import com.potato.api.sys.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 *
 * @author lizhifu
 * @date 2021/9/28
 */
@Component
@Slf4j
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable cause) {
        log.error("用户服务调用失败:{}", cause.getMessage());
        return new RemoteUserService()
        {
            @Override
            public R<LoginUser> getUserInfo(String username, String source)
            {
                return new R().error("获取用户失败:" + cause.getMessage(),500);
            }
        };
    }
}

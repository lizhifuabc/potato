package com.potato.auth.service.impl;

import com.commom.core.base.R;
import com.potato.api.sys.RemoteUserService;
import com.potato.api.sys.model.LoginUser;
import com.potato.core.constant.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息
 *
 * @author lizhifu
 * @date 2021/9/27
 */
@Slf4j
@Service
public class PotatoUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        R<LoginUser> userResult = remoteUserService.getUserInfo(username, SecurityConstants.INNER);
        return null;
    }
}

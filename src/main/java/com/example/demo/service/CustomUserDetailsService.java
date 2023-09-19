package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoService.getUserInfo(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用戶不存在");
        }

        userInfo.setRoleList(userMapper.getRolesById(userInfo.getId()));
        return userInfo;
    }
}

package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserMapper userMapper;

    //    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserInfoService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public UserInfo getUserInfo(String username) {
        return userMapper.getUserByUsername(username);
    }

    public int insertUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userMapper.insertUserInfo(userInfo);
    }
}

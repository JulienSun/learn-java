package com.example.demo;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void passwordEncode() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "123456";
        String passwordEncoded = encoder.encode(password);
        if (encoder.matches(password, passwordEncoded)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    void passwordInDBTest() {
        UserInfo userInfo = userInfoService.getUserInfo("user1");

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches("12345", userInfo.getPassword())) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUser")
    public UserInfo getUser(@RequestParam String username) {
        return userInfoService.getUserInfo(username);
    }

    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());
        
        return "hello, user";
    }

    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("/admin")
    public String admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        return "hello, admin";
    }

    @PreAuthorize("hasAnyRole('dba', 'admin')")
    @GetMapping("/db")
    public String dba() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        return "hello, dba, admin";
    }

    @PostMapping("/addUser")
    public int insertUser(@RequestBody UserInfo userInfo) {
        return userInfoService.insertUser(userInfo);
    }
}

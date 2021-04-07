package com.lee.userservice.controller;

import com.lee.userservice.entity.User;
import com.lee.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lee
 * @date 2021/3/22 13:14
 */
@RestController
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("/user/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable("userId") Long userId) {
        return userService.getUserByUserId(userId);
    }

//    @GetMapping("/userByUsername/{username}")
//    public User getUserByUsername(@PathVariable("username") String username) {
//        return userService.getUserByUsername(username);
//    }
}

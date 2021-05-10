package com.lee.authservice.controller;

import com.lee.authservice.exception.HttpException;
import com.lee.authservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/8 15:13
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody Map<String, String> userMap) throws HttpException {
        userService.addUser(userMap);
    }

    @DeleteMapping("/user-by-name/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
    }
}

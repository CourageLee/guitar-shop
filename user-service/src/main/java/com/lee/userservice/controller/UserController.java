package com.lee.userservice.controller;

import com.lee.userservice.entity.User;
import com.lee.userservice.exception.HttpException;
import com.lee.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/3/22 13:14
 */
@Slf4j
@RestController
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/user")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/user-by-id/{userId}")
    public User getUserByUserId(@PathVariable("userId") Long userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/user-by-name/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) throws HttpException {
        userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") String userId, @RequestBody User user) throws HttpException {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/user-by-id/{userId}")
    public void deleteUserByUserId(@PathVariable("userId") String userId) {
        userService.deleteUserByUserId(userId);
    }

    @DeleteMapping("/user-by-name/{username}")
    public void deleteUserByUsername(@PathVariable("username") String username) {
        userService.deleteUserByUsername(username);
    }
}

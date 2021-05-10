package com.lee.userservice.service;

import com.lee.userservice.entity.User;
import com.lee.userservice.exception.HttpException;

import java.util.List;

/**
 * @author Lee
 */
public interface UserService {
    List<User> listUser();

    /**
     * 通过用户ID获取用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    User getUserByUserId(Long userId);

    /**
     * 通过用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);


    /**
     * 插入用户信息
     * @param user
     */
    void addUser(User user) throws HttpException;

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(String userId, User user) throws HttpException;

    /**
     * 根据用户ID删除用户信息
     * @param userId
     */
    void deleteUserByUserId(String userId);

    /**
     * 根据用户名删除用户
     * @param username
     */
    void deleteUserByUsername(String username);
}

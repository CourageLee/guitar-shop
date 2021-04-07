package com.lee.userservice.service;

import com.lee.userservice.entity.User;

/**
 * @author Lee
 */
public interface UserService {
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
}

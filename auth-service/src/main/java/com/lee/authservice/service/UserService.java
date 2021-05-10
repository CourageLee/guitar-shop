package com.lee.authservice.service;

import com.lee.authservice.entity.User;
import com.lee.authservice.exception.HttpException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

/**
 * @author Lee
 * @date 2021/3/25 15:19
 */
public interface UserService extends UserDetailsService {

    /**
     * 新增用户,新增users表,user_role表,调用auth-service的/user|POST方法保存用户基本信息
     * @param userMap
     */
    void addUser(Map<String, String> userMap) throws HttpException;

    void deleteUser(String username);
}

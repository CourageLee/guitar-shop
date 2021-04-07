package com.lee.userservice.service.imp;

import com.lee.userservice.entity.User;
import com.lee.userservice.mapper.UserMapper;
import com.lee.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lee
 * @date 2021/3/25 17:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByUserId(Long userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}

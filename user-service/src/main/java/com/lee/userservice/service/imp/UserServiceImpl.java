package com.lee.userservice.service.imp;

import com.lee.userservice.entity.User;
import com.lee.userservice.exception.HttpException;
import com.lee.userservice.mapper.UserMapper;
import com.lee.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/3/25 17:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User getUserByUserId(Long userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) throws HttpException {
        checkUser(user);
        userMapper.saveUser(user);
    }

    @Override
    public void updateUser(String userId, User user) throws HttpException {
        if (!userId.equals(user.getId())) {
            throw new HttpException("用户信息校验失败", HttpStatus.BAD_REQUEST);
        }
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserByUserId(String userId) {
        userMapper.deleteUserByUserId(userId);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userMapper.deleteUserByUsername(username);
    }

    /**
     * 校验用户信息
     * @param user
     */
    private void checkUser(User user) throws HttpException {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new HttpException("用户名不能为空", HttpStatus.BAD_REQUEST);
        }
        if (user.getSex() == null) {
            user.setSex((short) 0);
        }
        if (user.getSex() != 0 && user.getSex() != 1 && user.getSex() != 2 && user.getSex() != 9) {
            throw new HttpException("用户性别信息错误", HttpStatus.BAD_REQUEST);
        }
        // TODO 验证号码与邮箱
    }
}

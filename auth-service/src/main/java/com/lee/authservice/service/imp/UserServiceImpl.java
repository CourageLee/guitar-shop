package com.lee.authservice.service.imp;

import com.lee.authservice.entity.Role;
import com.lee.authservice.entity.User;
import com.lee.authservice.exception.HttpException;
import com.lee.authservice.mapper.RoleMapper;
import com.lee.authservice.mapper.UserMapper;
import com.lee.authservice.mapper.UserRoleMapper;
import com.lee.authservice.service.UserService;
import com.lee.authservice.service.feign.UserFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Lee
 * @date 2021/3/25 15:20
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    UserFeignService userFeignService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void addUser(Map<String, String> userMap) throws HttpException {
        User user = convertUser(userMap);
        // 保存用户登录信息
        userMapper.addUser(user);
        // 设置user_role,默认角色为user
        String roleCode = userMap.get("role");
        if (roleCode == null || roleCode.isEmpty()) {
            roleCode = "user";
        }
        Role role = roleMapper.getRoleByRoleCode(roleCode);
        log.info("userId: " + user.getId() + " roleId: " + role.getId());
        userRoleMapper.addUserRole(user.getId(), role.getId());

        // 保存用户基本信息
        userFeignService.addUser(userMap);
    }

    private User convertUser(Map<String, String> userMap) throws HttpException {
        User user = new User();
        String username = userMap.get("username");
        if (username == null || username.isEmpty()) {
            throw new HttpException("用户名不能为空", HttpStatus.BAD_REQUEST);
        }
        user.setUsername(username);

        String rowPassword = userMap.get("password");
        if (rowPassword == null || rowPassword.isEmpty()) {
            throw new HttpException("密码不能为空", HttpStatus.BAD_REQUEST);
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(rowPassword));
        userMap.remove("password");
        return user;
    }

    @Override
    public void deleteUser(String username) {
        User user = userMapper.getUserByUsername(username);
        // 删除user表信息
        userMapper.deleteUser(user.getId());
        // 删除user_role表信息
        userRoleMapper.deleteUserRole(user.getId());
        // 调用auth-service删除用户基本信息
        userFeignService.deleteUser(user.getUsername());
    }
}

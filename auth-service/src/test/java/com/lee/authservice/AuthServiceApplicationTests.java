package com.lee.authservice;

import com.lee.authservice.entity.User;
import com.lee.authservice.mapper.UserMapper;
import com.lee.authservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class AuthServiceApplicationTests {
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

}

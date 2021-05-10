package com.lee.authservice;

import com.lee.authservice.entity.User;
import com.lee.authservice.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@MapperScan("com.lee.authservice.mapper")
@SpringBootApplication
@EnableFeignClients
public class AuthServiceApplication {
    @Resource
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "This is Auth Service";
    }

}

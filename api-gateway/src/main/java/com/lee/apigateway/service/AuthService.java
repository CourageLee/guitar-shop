package com.lee.apigateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@Service
@FeignClient(value = "AUTH-SERVICE")
public interface AuthService {
    /**
     * 使用token获取用户信息
     * @param token oauth token
     * @return 用户信息,若token无效,返回NULL
     */
    // TODO
    @PostMapping("/oauth/check_token")
    Map<String, ?> getUserByToken(@RequestParam("token") String token);

}

package com.lee.authservice.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/8 15:16
 */
@FeignClient(value = "USER-SERVICE")
public interface UserFeignService {

    /**
     * 保存用户基本信息
     * @param userMap
     */
    @PostMapping("/user")
    void addUser(@RequestBody Map<String, String> userMap);

    @DeleteMapping("/user-by-name/{username}")
    void deleteUser(@PathVariable("username") String username);
}

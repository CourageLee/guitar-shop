package com.lee.apigateway.filter;

import com.lee.apigateway.exception.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/5 18:10
 */
@Slf4j
public class Authentication {
    public static void verify(String path, String method, Map<String, ?> user) throws HttpException {
        if (user == null) {
            log.info("user为空，认证失败");
            throw new HttpException("user为空", HttpStatus.UNAUTHORIZED);
        }
        List<String> authorities = (List<String>) user.get("authorities");
        String url = path + "|" + method;

        log.info("url: " + url);
        log.info("user " + user.get("user_name") + " authorities: " + authorities.toString());

        AntPathMatcher matcher = new AntPathMatcher();
        for (String authority : authorities) {
            String[] split = authority.split("\\|");
            if (matcher.match(split[0], path) && method.equals(split[1])) {
                log.info("认证成功");
                return;
            }
        }
        log.info("认证失败");
        throw new HttpException("没有权限", HttpStatus.UNAUTHORIZED);
    }

}

package com.lee.apigateway.filter;

import com.lee.apigateway.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2021/3/29 14:03
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {
    @Resource
    AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final String loginPath = "/auth/oauth/token";
        final String notifyPath = "/payment/notify";

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getPath().toString();

        log.info("path: " + path);
        if (loginPath.equals(path)) {
            // 登录操作跳过鉴定
            log.info("登录操作，直接转发");
            return chain.filter(exchange);
        }
        if (notifyPath.equals(path)) {
            // 支付宝通知路径
            log.info("支付宝通知操作，直接转发");
            return chain.filter(exchange);
        }
        // TODO 鉴定权限

        HttpHeaders headers = request.getHeaders();
        List<String> tokens = headers.get("Authentication-Token");
        // 没有token，跳转至登录页面
        if (tokens == null || tokens.isEmpty()) {
            log.info("没有token");
            String url = "http://baidu.com";
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set(HttpHeaders.LOCATION, url);
            return response.setComplete();
        }

        String token = tokens.get(0);
        log.info("获取token: " + token);

//         检测token，获取用户信息
        // TODO 使用OpenFeign鉴定token
        Map<String, ?> user = null;
        try {
            user = authService.getUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            log.info("验证token, token无效");
            String url = "http://baidu.com";
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set(HttpHeaders.LOCATION, url);
            return response.setComplete();
        }
        log.info("验证token, token有效");
        for (Map.Entry<String, ?> entry : user.entrySet()) {
            log.info(entry.getKey() + ": " + entry.getValue().toString());
        }

        // 鉴定成功，放行让Spring Security鉴定权限
        // TODO 配置Spring Security


//        if (path.equals("/user/admin")) {
//            log.info("forbid");
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        log.info("after");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}

package com.lee.apigateway.filter;

import com.lee.apigateway.exception.HttpException;
import com.lee.apigateway.service.feign.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/5 14:24
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {
    @Resource
    AuthService authService;

    // TODO 删除test
    private static String[] excludeTest = {"/auth/auth|GET", "/auth/auth/*|GET", "/auth/auth-count|GET", "/auth/user|POST"};
    private static String[] excludeUrlAuth= {"/auth|GET", "/auth/oauth/token|POST", "/auth/oauth/check_token|POST"};
    private static String[] excludeUrlFile = {"/file|GET"};
    private static String[] excludeUrlUser = {"/user|GET"};
    private static String[] excludeUrlProduct = {
            "/product|GET",
            "/product/category|GET", "/product/category/*|GET", "/product/category-count",
            "/product/spu|GET", "/product/spu/*|GET", "/product/spu-count|GET",
            "/product/sku|GET", "/product/sku/*|GET", "/product/sku-by-spu|GET", "/product/sku-count|GET"
    };
    private static String[] excludeUrlOrder = {
            "/order|GET"
    };
    private static String[] excludeUrlPayment = {"/payment|GET"};

    private static List<String> excludeUrl = new ArrayList<>();

    public AuthFilter() {
        excludeUrl.addAll(Arrays.asList(excludeTest));
        excludeUrl.addAll(Arrays.asList(excludeUrlAuth));
        excludeUrl.addAll(Arrays.asList(excludeUrlFile));
        excludeUrl.addAll(Arrays.asList(excludeUrlUser));
        excludeUrl.addAll(Arrays.asList(excludeUrlProduct));
        excludeUrl.addAll(Arrays.asList(excludeUrlOrder));
        excludeUrl.addAll(Arrays.asList(excludeUrlPayment));
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("test filter 0");
        /**
         * 获取用户信息
         * 判断是否需要登录，是否有权限
         */
        ServerHttpRequest request = exchange.getRequest();

        // 获取用户信息
        HttpHeaders headers = request.getHeaders();
        List<String> tokens = headers.get("Authentication-Token");
        Map<String, ?> user = null;
        if (tokens != null) {
            String token = tokens.get(0);

            try {
                user = authService.getUserByToken(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        RequestPath path = request.getPath();
        HttpMethod method = request.getMethod();
        String url = path.value() + "|" + method.name();
        log.info("url: " + url);
        // 排除无需登录的路径
        if (excludeUrl.contains(url)) {
            return chain.filter(exchange);
        }

        // 鉴权
        // TODO 异常的处理
        try {
            Authentication.verify(path.value(), method.name(), user);
        } catch (HttpException e) {
            e.printStackTrace();
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(e.getStatus());
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

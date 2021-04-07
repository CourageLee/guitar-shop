package com.lee.apigateway.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Lee
 * @date 2021/3/26 16:43
 */
@Configuration
public class RouteConfig {
    /**
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.
                        path("/user/**")
                        .uri("http://localhost:8801")
                ).build();
    }
    */
}

package com.lee.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author Lee
 * @date 2021/3/25 11:23
 */
@Configuration
public class AccessTokenConfig {
    @Bean
    TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}

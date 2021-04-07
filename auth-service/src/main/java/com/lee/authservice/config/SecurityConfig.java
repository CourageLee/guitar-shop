package com.lee.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * @author Lee
 * @date 2021/3/22 13:40
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserDetailsService user;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // TODO 添加UserDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(user);
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED FROM USERS WHERE USERNAME = ?")
//                .authoritiesByUsernameQuery("SELECT USERNAME, ROLE_CODE FROM USERS FULL JOIN ROLES ON USERNAME = ? AND ROLES.ID IN ( SELECT ROLE_ID FROM USER_ROLE WHERE USER_ID = (SELECT ID FROM USERS WHERE USERNAME = ?))")
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());

//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123"))
//                .authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin();
    }
}

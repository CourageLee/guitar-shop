package com.lee.userservice.mapper;

import com.lee.userservice.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/3/22 22:47
 */
@Repository
public interface UserMapper {
    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    @Select("SELECT *FROM USERS WHERE ID = #{userId}")
    User getUserByUserId(Long userId);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @Select("SELECT *FROM USERS WHERE USERNAME = #{username}")
    User getUserByUsername(String username);
}

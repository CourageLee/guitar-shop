package com.lee.authservice.mapper;

import com.lee.authservice.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Lee
 * @date 2021/3/25 15:19
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户登录信息
     * @param username 用户名
     * @return 用户登录信息
     */
    @Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
    @Result(column = "ID", property = "id")
    @Result(column = "ID", property = "roles", many = @Many(select = "com.lee.authservice.mapper.RoleMapper.listRolesByUserId"))
    User getUserByUsername(String username);

    /**
     * 新增用户登录信息,返回新增的ID
     * @param user
     */
    @Insert("INSERT INTO USERS (username, password) VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(User user);


    @Delete("DELETE FROM USERS WHERE id = #{userId}")
    void deleteUser(String userId);

}

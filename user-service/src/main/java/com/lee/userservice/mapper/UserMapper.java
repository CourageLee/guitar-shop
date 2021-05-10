package com.lee.userservice.mapper;

import com.lee.userservice.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/3/22 22:47
 */
@Repository
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    @Select("SELECT *FROM USERS")
    List<User> listUser();

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    @Select("SELECT *FROM USERS WHERE id = #{userId}")
    User getUserByUserId(Long userId);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @Select("SELECT *FROM USERS WHERE username = #{username}")
    User getUserByUsername(String username);

    /**
     * 插入用户信息
     * @param user 用户信息
     */
    @Insert("INSERT INTO USERS (username, sex, birth, photo, phone, email) VALUES (#{username}, #{sex}, #{birth}, #{photo}, #{phone}, #{email})")
    void saveUser(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    @Update("UPDATE USERS SET username = #{username}, sex = #{sex}, birth = #{birth}, photo = #{photo}, phone = #{phone}, email = #{email} WHERE id = #{id}")
    void updateUser(User user);

    /**
     * 根据用户ID删除用户信息
     * @param userId 用户ID
     */
    @Delete("DELETE FROM USERS WHERE id = #{id}")
    void deleteUserByUserId(String userId);

    /**
     * 根据用户名删除用户
     * @param username 用户名称
     */
    @Delete("DELETE FROM USERS WHERE username = #{username}")
    void deleteUserByUsername(String username);
}
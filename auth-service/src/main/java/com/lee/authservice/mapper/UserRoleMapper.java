package com.lee.authservice.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/8 16:54
 */
public interface UserRoleMapper {
    /**
     * 新增用户_角色信息
     * @param userId
     * @param roleId
     */
    @Insert("INSERT INTO USER_ROLE VALUES (#{userId}, #{roleId})")
    void addUserRole(String userId, String roleId);

    @Delete("DELETE FROM USER_ROLE WHERE user_id = #{userId}")
    void deleteUserRole(String userId);


}

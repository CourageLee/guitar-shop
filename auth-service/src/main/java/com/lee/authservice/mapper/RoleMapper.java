package com.lee.authservice.mapper;

import com.lee.authservice.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author Lee
 * @date 2021/3/25 15:19
 */
public interface RoleMapper {
    /**
     * 根据用户ID查询角色
     * @param userId 用户ID
     * @return 角色信息
     */
    @Select("SELECT b.* FROM USER_ROLE a JOIN ROLES b ON a.USER_ID = #{userId} AND a.ROLE_ID = b.ID")
    @Result(column = "ID", property = "id")
    @Result(column = "ID", property = "authorities", many = @Many(select = "com.lee.authservice.mapper.AuthorityMapper.listAuthoritiesByRoleId"))
    List<Role> listRolesByUserId(Long userId);

    /**
     * 查询所有角色信息
     * @return
     */
    @Select("SELECT *FROM roles")
    List<Role> listRoles();

    /**
     * 根据角色code查询角色信息
     * @param roleCode
     * @return
     */
    @Select("SELECT *FROM roles WHERE role_code = #{roleCode}")
    Role getRoleByRoleCode(String roleCode);
}

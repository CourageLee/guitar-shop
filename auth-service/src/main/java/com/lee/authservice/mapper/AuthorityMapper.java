package com.lee.authservice.mapper;

import com.lee.authservice.entity.Authority;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lee
 * @date 2021/3/25 15:20
 */
public interface AuthorityMapper {
    /**
     * 根据角色ID查询权限
     * @param roleId 角色ID
     * @return 权限信息
     */
    @Select("SELECT b.* FROM ROLE_AUTH a JOIN AUTHORITIES b ON a.ROLE_ID = #{roleId} AND a.AUTHORITY_ID = b.ID")
    List<Authority> listAuthoritiesByRoleId(Long roleId);
}

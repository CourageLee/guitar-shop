package com.lee.userservice.mapper;

import com.lee.userservice.entity.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaMapper {
    /**
     * 根据父级id查询所有地域
     * @param pid 父级id
     * @return 所有地域
     */
    @Select("SELECT ID, NAME FROM AREA WHERE PID = #{pid}")
    List<Area> listAreasByPid(int pid);
}

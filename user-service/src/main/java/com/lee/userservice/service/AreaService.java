package com.lee.userservice.service;

import com.lee.userservice.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 根据pid获取地域信息
     * @param pid 父级id，0代表省份
     * @return 省市区街道信息
     */
    List<Area> listAreasByPid(int pid);
}

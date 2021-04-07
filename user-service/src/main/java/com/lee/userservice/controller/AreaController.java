package com.lee.userservice.controller;

import com.lee.userservice.entity.Area;
import com.lee.userservice.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 中国省市区街道信息
 * @author Lee
 * @date 2021/3/26 17:38
 */
@RestController
public class AreaController {
    @Resource
    AreaService areaService;

    @GetMapping("/province/{pid}")
    public List<Area> listProvince(@PathVariable("pid") int pid) {
        return areaService.listAreasByPid(pid);
    }
}
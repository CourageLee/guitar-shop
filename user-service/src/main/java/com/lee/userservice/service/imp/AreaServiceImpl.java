package com.lee.userservice.service.imp;

import com.lee.userservice.entity.Area;
import com.lee.userservice.mapper.AreaMapper;
import com.lee.userservice.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/3/26 17:53
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    AreaMapper areaMapper;

    @Override
    public List<Area> listAreasByPid(int pid) {
        return areaMapper.listAreasByPid(pid);
    }
}

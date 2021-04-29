package com.lee.productservice.service.impl;

import com.lee.productservice.dal.SpuDal;
import com.lee.productservice.entity.Spu;
import com.lee.productservice.exception.HttpException;
import com.lee.productservice.service.SpuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @date 2021/4/9 16:50
 */
@Service
@Slf4j
public class SpuServiceImpl implements SpuService {
    @Resource
    SpuDal spuDal;

    @Override
    public void saveSpu(Spu spu) throws HttpException {
        checkSpu(spu);
        spuDal.saveSpu(spu);
    }

    @Override
    public List<Spu> listSpu() {
        return spuDal.listSpu();
    }

    @Override
    public Spu getSpuById(String id) {
        return spuDal.getSpuById(id);
    }

    @Override
    public long count() {
        return spuDal.count();
    }

    @Override
    public List<Spu> listSpuPaginated(long pageNumber, int pageSize) {
        return spuDal.listSpuPaginated(pageNumber, pageSize);
    }

    @Override
    public void updateSpu(String id, Spu newSpu) throws HttpException {
        Spu oldSpu = getSpuById(id);
        newSpu.setId(oldSpu.getId());
        newSpu.setCreateTime(oldSpu.getCreateTime());
        saveSpu(newSpu);
    }

    @Override
    public void deleteSpu(String id) {
        spuDal.deleteSpu(id);
    }

    /**
     * 校验并设置基本信息
     * @param spu spu
     * @throws HttpException
     */
    private void checkSpu(Spu spu) throws HttpException {
        if (spu.getCreateTime() == null) {
            spu.setCreateTime(new Date());
        }

        spu.setUpdateTime(new Date());

        // TODO 设置创建者信息
        spu.setCreatorId("admin");
        if (spu.getName() == null || spu.getName().isEmpty()) {
            throw new HttpException("spu name不能为空", HttpStatus.BAD_REQUEST);
        }
        if (spu.getBrand() == null || spu.getBrand().isEmpty()) {
            throw new HttpException("spu brand不能为空", HttpStatus.BAD_REQUEST);
        }
        if (spu.getDescription() == null || spu.getDescription().isEmpty()) {
            throw new HttpException("spu description不能为空", HttpStatus.BAD_REQUEST);
        }
    }


}

package com.lee.productservice.service.impl;

import com.lee.productservice.dal.SkuDal;
import com.lee.productservice.entity.Sku;
import com.lee.productservice.entity.Spu;
import com.lee.productservice.exception.HttpException;
import com.lee.productservice.service.SkuService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2021/4/9 16:50
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Resource
    SkuDal skuDal;

    @Override
    public void saveSku(Sku sku) throws HttpException {
        checkSku(sku);
        skuDal.saveSku(sku);
    }

    @Override
    public long count() {
       return skuDal.count();
    }

    @Override
    public List<Sku> listSku() {
        return skuDal.listSku();
    }

    @Override
    public Sku getSkuById(String id) {
        return skuDal.getSkuById(id);
    }

    @Override
    public List<Map<String, String>> listSkuBySpu(String spu) {
        return skuDal.listSkuBySpu(spu);
    }

    @Override
    public List<Sku> listSkuPaginated(long pageNumber, int pageSize) {
        return skuDal.listSkuPaginated(pageNumber, pageSize);
    }

    @Override
    public void updateSku(String id, Sku newSku) throws HttpException {
        Sku oldSku = getSkuById(id);
        newSku.setId(oldSku.getId());
        newSku.setCreateTime(oldSku.getCreateTime());
        saveSku(newSku);
    }

    @Override
    public void deleteSku(String id) {
        skuDal.deleteSku(id);
    }

    /**
     * 校验并设置基本信息
     * @param sku sku
     * @throws HttpException
     */
    private void checkSku(Sku sku) throws HttpException {
        if (sku.getCreateTime() == null) {
            sku.setCreateTime(new Date());
        }

        sku.setUpdateTime(new Date());

        // TODO 设置创建者信息
        sku.setCreatorId("admin");
        if (sku.getName() == null || sku.getName().isEmpty()) {
            throw new HttpException("sku name不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getModel() == null || sku.getModel().isEmpty()) {
            throw new HttpException("sku model不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getSpu() == null || sku.getSpu().isEmpty()) {
            throw new HttpException("sku spu不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getCategories() == null || sku.getCategories().isEmpty()) {
            throw new HttpException("sku categories不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getRetail() == null) {
            throw new HttpException("sku retail不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getSale() == null) {
            sku.setSale(sku.getRetail());
        }
        if (sku.getMainImage() == null) {
            throw new HttpException("sku mainImage不能为空", HttpStatus.BAD_REQUEST);
        }
        if (sku.getDetailImages() == null || sku.getDetailImages().isEmpty()) {
            throw new HttpException("sku detailImages不能为空", HttpStatus.BAD_REQUEST);
        }
    }
}

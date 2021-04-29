package com.lee.productservice.service.impl;

import com.lee.productservice.dal.SkuDal;
import com.lee.productservice.entity.Sku;
import com.lee.productservice.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/4/9 16:50
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Resource
    SkuDal skuDal;

    @Override
    public void saveSku(Sku sku) {
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
    public List<Sku> listSkuPaginated(long pageNumber, int pageSize) {
        return skuDal.listSkuPaginated(pageNumber, pageSize);
    }
}

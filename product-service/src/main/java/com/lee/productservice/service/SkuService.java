package com.lee.productservice.service;

import com.lee.productservice.entity.Sku;
import com.lee.productservice.exception.HttpException;

import java.util.List;
import java.util.Map;

public interface SkuService {
    void saveSku(Sku sku) throws HttpException;

    long count();

    List<Sku> listSku();

    Sku getSkuById(String id);

    List<Map<String, String>> listSkuBySpu(String spu);

    /**
     * 分页查询
     * @param pageNumber 跳过的页数
     * @param pageSize 每页的数量
     * @return 产品列表
     */
    List<Sku> listSkuPaginated(long pageNumber, int pageSize);

    void updateSku(String id, Sku sku) throws HttpException;

    void deleteSku(String id);
}

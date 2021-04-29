package com.lee.productservice.service;

import com.lee.productservice.entity.Sku;

import java.util.List;

public interface SkuService {
    void saveSku(Sku sku);

    long count();

    List<Sku> listSku();

    /**
     * 分页查询
     * @param pageNumber 跳过的页数
     * @param pageSize 每页的数量
     * @return 产品列表
     */
    List<Sku> listSkuPaginated(long pageNumber, int pageSize);
}

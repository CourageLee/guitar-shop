package com.lee.productservice.dal;

import com.lee.productservice.entity.Sku;

import java.util.List;
import java.util.Map;

public interface SkuDal {
    void saveSku(Sku sku);

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

    void deleteSku(String id);
}

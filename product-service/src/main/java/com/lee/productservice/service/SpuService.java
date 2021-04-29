package com.lee.productservice.service;

import com.lee.productservice.entity.Spu;
import com.lee.productservice.exception.HttpException;

import java.util.List;

public interface SpuService {
    void saveSpu(Spu spu) throws HttpException;

    List<Spu> listSpu();

    Spu getSpuById(String id);

    long count();

    /**
     * 分页查询
     * @param pageNumber 跳过的页数
     * @param pageSize 每页的数量
     * @return 产品列表
     */
    List<Spu> listSpuPaginated(long pageNumber, int pageSize);

    void updateSpu(String id, Spu spu) throws HttpException;

    void deleteSpu(String id);
}

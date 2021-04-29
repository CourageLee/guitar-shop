package com.lee.productservice.dal;

import com.lee.productservice.entity.Spu;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:11
 */
public interface SpuDal {
    void saveSpu(Spu spu);

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

    void deleteSpu(String id);

}

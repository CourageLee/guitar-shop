package com.lee.productservice.dal;

import com.lee.productservice.entity.Product;

import java.util.List;

public interface ProductDAL {
    void saveProduct(Product product);

    List<Product> listProducts();

    /**
     * 分页查询
     * @param pageNumber 跳过的页数
     * @param pageSize 每页的数量
     * @return 产品列表
     */
    List<Product> listProductsPaginated(long pageNumber, int pageSize);
}

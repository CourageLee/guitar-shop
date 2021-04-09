package com.lee.productservice.service.impl;

import com.lee.productservice.dal.ProductDAL;
import com.lee.productservice.entity.Product;
import com.lee.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/4/9 16:50
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDAL productDAL;

    @Override
    public void saveProduct(Product product) {
        productDAL.saveProduct(product);
    }

    @Override
    public List<Product> listProducts() {
        return productDAL.listProducts();
    }

    @Override
    public List<Product> listProductsPaginated(long pageNumber, int pageSize) {
        return productDAL.listProductsPaginated(pageNumber, pageSize);
    }
}

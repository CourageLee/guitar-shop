package com.lee.productservice.dal.impl;

import com.lee.productservice.dal.ProductDAL;
import com.lee.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lee
 * @date 2021/4/9 13:52
 */
@Repository
public class ProductDALImpl implements ProductDAL {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProductDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveProduct(Product product) {
        mongoTemplate.save(product);
    }

    @Override
    public List<Product> listProducts() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public List<Product> listProductsPaginated(long pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Product.class);
    }
}

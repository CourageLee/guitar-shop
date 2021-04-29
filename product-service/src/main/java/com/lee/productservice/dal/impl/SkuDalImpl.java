package com.lee.productservice.dal.impl;

import com.lee.productservice.dal.SkuDal;
import com.lee.productservice.entity.Category;
import com.lee.productservice.entity.Sku;
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
public class SkuDalImpl implements SkuDal {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public SkuDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveSku(Sku sku) {
        mongoTemplate.save(sku);
    }

    @Override
    public long count() {
        return mongoTemplate.count(new Query(), Sku.class);
    }

    @Override
    public List<Sku> listSku() {
        return mongoTemplate.findAll(Sku.class);
    }

    @Override
    public List<Sku> listSkuPaginated(long pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Sku.class);
    }
}

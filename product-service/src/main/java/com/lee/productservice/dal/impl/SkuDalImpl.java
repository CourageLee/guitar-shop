package com.lee.productservice.dal.impl;

import com.lee.productservice.dal.SkuDal;
import com.lee.productservice.entity.Category;
import com.lee.productservice.entity.Sku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2021/4/9 13:52
 */
@Slf4j
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
        log.info("sku [" + sku.getName() + "] is saved");
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
    public Sku getSkuById(String id) {
        return mongoTemplate.findById(id, Sku.class);
    }

    @Override
    public List<Map<String, String>> listSkuBySpu(String spu) {
        List<Map<String, String>> res = new ArrayList<>();
        Query query = new Query(Criteria.where("spu").is(spu));
        List<Sku> skus = mongoTemplate.find(query, Sku.class);
        for (Sku sku : skus) {
            Map<String, String> s = new HashMap<>();
            s.put("name", sku.getName());
            s.put("id", sku.getId());
            res.add(s);
        }
        return res;
    }

    @Override
    public List<Sku> listSkuPaginated(long pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Sku.class);
    }

    @Override
    public void deleteSku(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Sku.class);
        log.info("sku [" + id + "] is deleted");
    }
}

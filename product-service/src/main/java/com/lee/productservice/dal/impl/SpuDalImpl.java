package com.lee.productservice.dal.impl;

import com.lee.productservice.dal.SpuDal;
import com.lee.productservice.entity.Category;
import com.lee.productservice.entity.Spu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:13
 */
@Repository
@Slf4j
public class SpuDalImpl implements SpuDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SpuDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveSpu(Spu spu) {
        mongoTemplate.save(spu);
        log.info("spu " + spu.getName() + " is saved");
    }

    @Override
    public List<Spu> listSpu() {
        return mongoTemplate.findAll(Spu.class);
    }

    @Override
    public Spu getSpuById(String id) {
        return mongoTemplate.findById(id, Spu.class);
    }

    @Override
    public long count() {
        return mongoTemplate.count(new Query(), Spu.class);

    }

    @Override
    public List<Spu> listSpuPaginated(long pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Spu.class);
    }

    @Override
    public void deleteSpu(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Spu.class);
        log.info("spu " + id + " is deleted");
    }
}

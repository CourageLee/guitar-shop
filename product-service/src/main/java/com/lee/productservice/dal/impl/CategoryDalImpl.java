package com.lee.productservice.dal.impl;

import com.lee.productservice.dal.CategoryDal;
import com.lee.productservice.entity.Category;
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
 * @date 2021/4/23 10:22
 */
@Slf4j
@Repository
public class CategoryDalImpl implements CategoryDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CategoryDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveCategory(Category category) {
        mongoTemplate.save(category);
        log.info("category " + category.getName() + "is saved");
    }

    @Override
    public long count() {
        return mongoTemplate.count(new Query(), Category.class);
    }

    @Override
    public List<Category> listCategory() {
        return mongoTemplate.findAll(Category.class);
    }

    @Override
    public List<Category> listCategoryPaginated(long pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Category.class);
    }

    @Override
    public Category getCategoryById(String id) {
        return mongoTemplate.findById(id, Category.class);
    }

    @Override
    public void deleteCategory(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Category.class);
        log.info("category " + id + " is deleted");
    }
}

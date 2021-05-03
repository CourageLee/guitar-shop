package com.lee.orderservice.dal.impl;

import com.lee.orderservice.dal.CartDal;
import com.lee.orderservice.entity.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 所有查询操作都必须提供userId
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:22
 */
@Slf4j
@Repository
public class CartDalImpl implements CartDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CartDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveCart(Cart cart) {
        mongoTemplate.save(cart);
        log.info("cart [" + cart.getId() + "] is saved");
    }

    @Override
    public long count(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.count(query, Cart.class);
    }


    @Override
    public List<Cart> listCart(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.find(query, Cart.class);
    }

    @Override
    public List<Cart> listCartPaginated(String username, long pageNumber, int pageSize) {
        Query query = new Query(Criteria.where("username").is(username));
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Cart.class);
    }

    @Override
    public Cart getCartById(String id) {
        return mongoTemplate.findById(id, Cart.class);
    }

    @Override
    public void deleteCart(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Cart.class);
        log.info("cart [" + id + "] is deleted");
    }
}

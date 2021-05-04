package com.lee.orderservice.dal.impl;

import com.lee.orderservice.dal.OrderDal;
import com.lee.orderservice.entity.Order;
import com.lee.orderservice.entity.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 17:59
 */
@Slf4j
@Repository
public class OrderDalImpl implements OrderDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public OrderDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Order saveOrder(Order order) {
        Order newOrder = mongoTemplate.save(order, "order");
        log.info("order [" + order.getId() + "] is saved");
        return newOrder;
    }

    @Override
    public long count(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.count(query, Order.class, "order");
    }

    @Override
    public List<Order> listOrder(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.find(query, Order.class, "order");
    }

    @Override
    public List<Order> listOrderPaginated(String username, long pageNumber, int pageSize) {
        Query query = new Query(Criteria.where("username").is(username));
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Order.class, "order");
    }

    @Override
    public Order getOrderById(String id) {
        return mongoTemplate.findById(id, Order.class, "order");
    }

    @Override
    public void deleteOrder(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Order.class, "order");
        log.info("order [" + id + "] is deleted");
    }

    @Override
    public void updateOrderStatus(String id, OrderStatus status) {
        OrderStatus oldStatus = getOrderById(id).getStatus();
        Update update = new Update();
        update.set("status", status);
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.updateFirst(query, update, Order.class, "order");
        log.info("order [" + id + "] status is set from " + oldStatus + " to " + status);
    }
}

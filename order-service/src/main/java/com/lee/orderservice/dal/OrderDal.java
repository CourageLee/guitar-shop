package com.lee.orderservice.dal;

import com.lee.orderservice.entity.Order;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 17:56
 */
public interface OrderDal {
    void saveOrder(Order order);

    long count(String username);

    List<Order> listOrder(String username);

    List<Order> listOrderPaginated(String username, long pageNumber, int pageSize);

    Order getOrderById(String id);

    /**
     * TODO 正式环境下取消该操作
     * @param id
     */
    void deleteOrder(String id);
}

package com.lee.orderservice.service;

import com.lee.orderservice.entity.Order;
import com.lee.orderservice.entity.OrderStatus;
import com.lee.orderservice.exception.HttpException;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 18:09
 */
public interface OrderService {
    Order saveOrder(Order order) throws HttpException;

    long count(String username);

    List<Order> listOrder(String username);

    List<Order> listOrderPaginated(String username, long pageNumber, int pageSize);

    Order getOrderById(String id);

    /**
     * TODO 正式环境下取消该操作
     * @param id
     */
    void deleteOrder(String id);

    /**
     * 更改订单状态
     * @param id
     */
    void updateOrderStatus(String id, OrderStatus status);
}

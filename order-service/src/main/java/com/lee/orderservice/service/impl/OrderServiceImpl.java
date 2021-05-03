package com.lee.orderservice.service.impl;

import com.lee.orderservice.dal.OrderDal;
import com.lee.orderservice.entity.Order;
import com.lee.orderservice.entity.OrderStatus;
import com.lee.orderservice.entity.Sku;
import com.lee.orderservice.exception.HttpException;
import com.lee.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 18:12
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDal orderDal;

    @Override
    public void saveOrder(Order order) throws HttpException {
        checkOrder(order);
        // TODO 锁定并减少sku库存
        orderDal.saveOrder(order);
    }

    @Override
    public long count(String username) {
        return orderDal.count(username);
    }

    @Override
    public List<Order> listOrder(String username) {
        return orderDal.listOrder(username);
    }

    @Override
    public List<Order> listOrderPaginated(String username, long pageNumber, int pageSize) {
        return orderDal.listOrderPaginated(username, pageNumber, pageSize);
    }

    @Override
    public Order getOrderById(String id) {
        return orderDal.getOrderById(id);
    }

    @Override
    public void deleteOrder(String id) {
        orderDal.deleteOrder(id);
    }

    @Override
    public void updateOrderStatus(String id, OrderStatus status) {
        // TODO 待完成
    }

    /**
     * 检查订单
     * @param order
     */
    private void checkOrder(Order order) throws HttpException {
        if (order.getCreateTime() == null) {
            order.setCreateTime(new Date());
        }

        order.setUpdateTime(new Date());

        // TODO 设置创建者信息
        order.setCreatorId("admin");

        // 计算订单总金额
        Double orderRetail = 0D;
        for (Sku sku : order.getSkus()) {
            orderRetail += sku.getCartSum();
        }
        order.setOrderRetail(orderRetail);
        // 将订单实际总金额设置为0.1元,演示用
        order.setOrderSale(0.1D);

        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.NON_PAYMENT);
        }

        if (order.getUsername() == null || order.getUsername().isEmpty()) {
            throw new HttpException("order username不能为空", HttpStatus.BAD_REQUEST);
        }
        if (order.getSkus() == null || order.getSkus().isEmpty()) {
            throw new HttpException("order skus不能为空", HttpStatus.BAD_REQUEST);
        }
    }
}

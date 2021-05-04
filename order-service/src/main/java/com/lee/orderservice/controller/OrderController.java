package com.lee.orderservice.controller;

import com.lee.orderservice.entity.Order;
import com.lee.orderservice.entity.OrderStatus;
import com.lee.orderservice.exception.HttpException;
import com.lee.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 18:44
 */
@Slf4j
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/order")
    public List<Order> listOrderPaginated(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "pageNumber", required = false) Long pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) throws HttpException {
        if (pageNumber == null && pageSize == null) {
            return orderService.listOrder(username);
        } else if (pageNumber != null && pageSize != null) {
            return orderService.listOrderPaginated(username, pageNumber, pageSize);
        } else {
            throw new HttpException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") String id) {
        return orderService.getOrderById(id);
    }


    @GetMapping("/order-count")
    public long getOrderCount(@RequestParam("username") String username) {
        return orderService.count(username);
    }

    @PostMapping("/order")
    public Order saveOrder(@RequestBody Order order) throws HttpException {
        log.info(order.toString());
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id") String id) {
        orderService.deleteOrder(id);
    }

    @PatchMapping("/order/{id}")
    public void updateOrderStatus(@PathVariable("id") String id, @RequestParam("status")OrderStatus status) {
        log.info("id: " + id + "; status: " + status);
        orderService.updateOrderStatus(id, status);
    }
}

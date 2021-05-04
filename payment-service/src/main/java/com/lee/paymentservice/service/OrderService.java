package com.lee.paymentservice.service;

import com.lee.paymentservice.entity.OrderStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/4 15:28
 */
@FeignClient(value = "ORDER-SERVICE")
public interface OrderService {
    /**
     * 修改订单状态
     * @param id
     * @param status
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PATCH)
    void updateOrderStatus(@PathVariable("id") String id, @RequestParam("status") OrderStatus status);
}

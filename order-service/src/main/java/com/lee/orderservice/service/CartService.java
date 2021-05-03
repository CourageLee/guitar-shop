package com.lee.orderservice.service;


import com.lee.orderservice.entity.Cart;
import com.lee.orderservice.exception.HttpException;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:24
 */
public interface CartService {
    void saveCart(Cart cart) throws HttpException;

    long count(String userName);

    List<Cart> listCart(String userName);

    List<Cart> listCartPaginated(String userName, long pageNumber, int pageSize);

    Cart getCartById(String id);

    void deleteCart(String id);

    void updateCart(String id, Cart newCart) throws HttpException;
}

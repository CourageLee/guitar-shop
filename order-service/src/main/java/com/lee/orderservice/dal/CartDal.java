package com.lee.orderservice.dal;

import com.lee.orderservice.entity.Cart;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:21
 */
public interface CartDal {
    void saveCart(Cart cart);

    long count(String username);

    List<Cart> listCart(String username);

    List<Cart> listCartPaginated(String username, long pageNumber, int pageSize);

    Cart getCartById(String id);

    void deleteCart(String id);
}

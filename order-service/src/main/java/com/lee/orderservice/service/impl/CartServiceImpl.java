package com.lee.orderservice.service.impl;

import com.lee.orderservice.dal.CartDal;
import com.lee.orderservice.entity.Cart;
import com.lee.orderservice.exception.HttpException;
import com.lee.orderservice.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:24
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartDal cartDal;

    @Override
    public void saveCart(Cart cart) throws HttpException {
        checkCart(cart);
        cartDal.saveCart(cart);
    }

    @Override
    public long count(String userName) {
        return cartDal.count(userName);
    }

    @Override
    public List<Cart> listCart(String userName) {
        return cartDal.listCart(userName);
    }

    @Override
    public List<Cart> listCartPaginated(String userName, long pageNumber, int pageSize) {
        return cartDal.listCartPaginated(userName, pageNumber, pageSize);
    }

    @Override
    public Cart getCartById(String id) {
        return cartDal.getCartById(id);
    }

    @Override
    public void deleteCart(String id) {
        cartDal.deleteCart(id);
    }

    @Override
    public void updateCart(String id, Cart newCart) throws HttpException {
        Cart oldCart = getCartById(id);
        newCart.setId(oldCart.getId());
        newCart.setCreateTime(oldCart.getCreateTime());
        saveCart(newCart);
    }

    private void checkCart(Cart cart) throws HttpException {
        if (cart.getCreateTime() == null) {
            cart.setCreateTime(new Date());
        }

        cart.setUpdateTime(new Date());

        // TODO 设置创建者信息
        cart.setCreatorId("admin");
        if (cart.getUsername() == null || cart.getUsername().isEmpty()) {
            throw new HttpException("cart username不能为空", HttpStatus.BAD_REQUEST);
        }
        if (cart.getSkuId() == null || cart.getSkuId().isEmpty()) {
            throw new HttpException("cart skuId不能为空", HttpStatus.BAD_REQUEST);
        }
        if (cart.getNumber() == 0) {
            throw new HttpException("cart number不能为0", HttpStatus.BAD_REQUEST);
        }
    }
}

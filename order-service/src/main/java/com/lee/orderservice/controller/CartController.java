package com.lee.orderservice.controller;

import com.lee.orderservice.entity.Cart;
import com.lee.orderservice.exception.HttpException;
import com.lee.orderservice.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/24 15:47
 */
@Slf4j
@RestController
public class CartController {
    @Resource
    CartService cartService;

    @GetMapping("/cart")
    public List<Cart> listCartPaginated(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "pageNumber", required = false) Long pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) throws HttpException {
        if (pageNumber == null && pageSize == null) {
            return cartService.listCart(username);
        } else if (pageNumber != null && pageSize != null) {
            return cartService.listCartPaginated(username, pageNumber, pageSize);
        } else {
            throw new HttpException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable("id") String id) {
        return cartService.getCartById(id);
    }


    @GetMapping("/cart-count")
    public long getCartCount(@RequestParam("username") String username) {
        return cartService.count(username);
    }

    @PostMapping("/cart")
    public void saveCart(@RequestBody Cart cart) throws HttpException {
        log.info(cart.toString());
        cartService.saveCart(cart);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable("id") String id) {
        cartService.deleteCart(id);
    }

    @PutMapping("/cart/{id}")
    public void updateCart(@PathVariable("id") String id, @RequestBody Cart newCart) throws HttpException {
        cartService.updateCart(id, newCart);
    }
}

package com.lee.productservice.controller;

import com.lee.productservice.entity.Product;
import com.lee.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @date 2021/4/9 13:35
 */
@RestController
@Slf4j
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("/hello")
    public String hello() {
        log.debug("hello controller");
        return "Hello, product service is running";
    }

    @GetMapping("/products")
    public List<Product> listProducts(@RequestParam(value = "pageNumber", required = false) Long pageNumber, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        log.debug("pageNumber: " + pageNumber + ", pageSize: " + pageSize);
        if(pageNumber != null && pageSize != null) {
            return productService.listProductsPaginated(pageNumber, pageSize);
        } else {
            return productService.listProducts();
        }
    }

    @PostMapping("/products")
    public void addProduct() {

    }
}

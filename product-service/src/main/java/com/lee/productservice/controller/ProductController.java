package com.lee.productservice.controller;

import com.lee.productservice.entity.Sku;
import com.lee.productservice.service.SkuService;
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
    SkuService skuService;

    @GetMapping("/hello")
    public String hello() {
        log.debug("hello controller");
        return "Hello, product service is running";
    }

    @GetMapping("/sku")
    public List<Sku> listProducts(@RequestParam(value = "pageNumber", required = false) Long pageNumber, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        log.debug("pageNumber: " + pageNumber + ", pageSize: " + pageSize);
        if(pageNumber != null && pageSize != null) {
            return skuService.listSkuPaginated(pageNumber, pageSize);
        } else {
            return skuService.listSku();
        }
    }

    @PostMapping("/products")
    public void addProduct() {

    }
}

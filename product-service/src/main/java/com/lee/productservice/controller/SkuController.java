package com.lee.productservice.controller;

import com.lee.productservice.entity.Sku;
import com.lee.productservice.exception.HttpException;
import com.lee.productservice.service.SkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/29 16:00
 * TODO @CrossOrigin为开发测试用途，正式环境下需禁用
 */
@Slf4j
@RestController
//@CrossOrigin
public class SkuController {
    @Resource
    SkuService skuService;

    @GetMapping("/sku")
    public List<Sku> listProducts(
            @RequestParam(value = "pageNumber", required = false) Long pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) throws HttpException {
        log.debug("pageNumber: " + pageNumber + ", pageSize: " + pageSize);

        if (pageNumber == null && pageSize == null) {
            return skuService.listSku();
        } else if (pageNumber != null && pageSize != null) {
            return skuService.listSkuPaginated(pageNumber, pageSize);
        } else {
            throw new HttpException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sku/{id}")
    public Sku getSkuById(@PathVariable("id") String id) {
        return skuService.getSkuById(id);
    }

    /**
     * 根据spu查找sku
     * @param spu spu
     * @return 包含sku名称和id的map列表
     */
    @GetMapping("/sku-by-spu")
    public List<Map<String, String>> listSkuBySpu(@RequestParam("spu") String spu) {
        return skuService.listSkuBySpu(spu);
    }

    @GetMapping("/sku-count")
    public long getSkuCount() {
        return skuService.count();
    }

    @PostMapping("/sku")
    public void saveSku(@RequestBody Sku sku) throws HttpException {
        log.info(sku.toString());
        skuService.saveSku(sku);
    }

    @PutMapping("/sku/{id}")
    public void updateSku(@PathVariable("id") String id, @RequestBody Sku sku) throws HttpException {
        skuService.updateSku(id, sku);
    }

    @DeleteMapping("/sku/{id}")
    public void deleteSku(@PathVariable("id") String id) {
        skuService.deleteSku(id);
    }
}

package com.lee.productservice.controller;

import com.lee.productservice.entity.Spu;
import com.lee.productservice.exception.HttpException;
import com.lee.productservice.service.SpuService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/26 14:08
 */
@RestController
public class SpuController {
    @Resource
    SpuService spuService;

    @GetMapping("/spu")
    public List<Spu> listSpu(
            @RequestParam(value = "pageNumber", required = false) Long pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) throws HttpException {
        if (pageNumber == null && pageSize == null) {
            return spuService.listSpu();
        } else if (pageNumber != null && pageSize != null) {
            return spuService.listSpuPaginated(pageNumber, pageSize);
        } else {
            throw new HttpException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/spu/{id}")
    public Spu getSpuById(@PathVariable("id") String id) {
        return spuService.getSpuById(id);
    }

    @GetMapping("/spu-count")
    public long getSpuCount() {
        return spuService.count();
    }

    @PostMapping("/spu")
    public void saveSpu(@RequestBody Spu spu) throws HttpException {
        spuService.saveSpu(spu);
    }

    @PutMapping("/spu/{id}")
    public void updateSpu(@PathVariable("id") String id, @RequestBody Spu spu) throws HttpException {
        spuService.updateSpu(id, spu);
    }

    @DeleteMapping("/spu/{id}")
    public void deleteSpu(@PathVariable("id") String id) {
        spuService.deleteSpu(id);
    }

}

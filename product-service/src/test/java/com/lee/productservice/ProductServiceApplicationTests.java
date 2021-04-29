package com.lee.productservice;

import com.lee.productservice.dal.CategoryDal;
import com.lee.productservice.dal.SkuDal;
import com.lee.productservice.entity.Sku;
import com.lee.productservice.util.InitData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@SpringBootTest
@Slf4j
class ProductServiceApplicationTests {
    @Resource
    SkuDal skuDAL;
    @Resource
    CategoryDal categoryDal;

//    @Test
    void initCategory() throws IOException {
        InitData.initCategory();
    }

    @Test
    void count() {
        System.out.println(categoryDal.count());
    }

//    @Test
    void addProduct() {
        for (int i = 0; i < 1; i++) {
            List<String> category = new ArrayList<>(Collections.singletonList("古典吉他categoryId"));
            List<String> detailImages = new ArrayList<>(Arrays.asList("detail-image-uri1", "detail-image-uri2"));
            Map<String, String> details = new HashMap<>();
            details.put("箱体材质分类", "面单");
            details.put("品牌原产地", "英国");
            details.put("卷弦器", "其他");
            Sku sku = new Sku();
            skuDAL.saveSku(sku);
        }
    }
}
package com.lee.productservice;

import com.lee.productservice.dal.ProductDAL;
import com.lee.productservice.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
@Slf4j
class ProductServiceApplicationTests {
    @Resource
    ProductDAL productDAL;

//    @Test
    void addProduct() {
        for (int i = 0; i < 1; i++) {
            List<String> category = new ArrayList<>(Collections.singletonList("古典吉他categoryId"));
            List<String> detailImages = new ArrayList<>(Arrays.asList("detail-image-uri1", "detail-image-uri2"));
            Map<String, String> details = new HashMap<>();
            details.put("箱体材质分类", "面单");
            details.put("品牌原产地", "英国");
            details.put("卷弦器", "其他");
            Product product = new Product(
                    new Date(),
                    new Date(),
                    "creator-01",
                    "雅马哈（YAMAHA）正品FG830单板民谣木吉他电箱指弹唱专业表演奏琴850",
                    "雅马哈(YAMAHA)FG830弦乐器",
                    "FG830原木色民谣41寸",
                    "雅马哈(YAMAHA)",
                    category,
                    4900.00,
                    4900.00,
                    true,
                    10,
                    5,
                    "main-image-uri1",
                    detailImages,
                    "description1",
                    4.5F,
                    20,
                    details);
            productDAL.saveProduct(product);
        }
    }
}
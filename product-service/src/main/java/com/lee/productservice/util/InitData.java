package com.lee.productservice.util;


import com.alibaba.fastjson.JSON;
import com.lee.productservice.entity.Category;
import com.lee.productservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/24 10:44
 */
@Slf4j
@Component
public class InitData {
    @Resource
    CategoryService categoryServiceAuto;

    static CategoryService categoryService;

    @PostConstruct
    public void init() {
        categoryService = this.categoryServiceAuto;
    }


    static final File CATEGORY_FILE = new File("src/main/resources/data/category.json");

    public static void initCategory() throws IOException {
        String s = FileUtils.readFileToString(CATEGORY_FILE, StandardCharsets.UTF_8);
        List<Category> categories = JSON.parseArray(s, Category.class);
        for (Category category : categories) {
            category.setCreateTime(new Date());
            category.setUpdateTime(new Date());
            categoryService.saveCategory(category);
        }
        log.info("categories: ");
        log.info(categories.toString());

    }
}

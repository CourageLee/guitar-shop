package com.lee.productservice.controller;

import com.lee.productservice.entity.Category;
import com.lee.productservice.exception.HttpException;
import com.lee.productservice.service.CategoryService;
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
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> listCategoryPaginated(
            @RequestParam(value = "pageNumber", required = false) Long pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) throws HttpException {
        if (pageNumber == null && pageSize == null) {
            return categoryService.listCategory();
        } else if (pageNumber != null && pageSize != null) {
            return categoryService.listCategoryPaginated(pageNumber, pageSize);
        } else {
            throw new HttpException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable("id") String id) {
        return categoryService.getCategoryById(id);
    }


    @GetMapping("/category-count")
    public long getCategoryCount() {
        return categoryService.count();
    }

    @PostMapping("/category")
    public void saveCategory(@RequestBody Category category) {
        log.info(category.toString());
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") String id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/category/{id}")
    public void updateCategory(@PathVariable("id") String id, @RequestBody Category newCategory) {
        categoryService.updateCategory(id, newCategory);
    }
}

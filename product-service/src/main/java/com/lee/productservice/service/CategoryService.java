package com.lee.productservice.service;

import com.lee.productservice.entity.Category;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:24
 */
public interface CategoryService {
    void saveCategory(Category category);

    long count();

    List<Category> listCategory();

    List<Category> listCategoryPaginated(long pageNumber, int pageSize);

    Category getCategoryById(String id);

    void deleteCategory(String id);

    void updateCategory(String id, Category newCategory);
}

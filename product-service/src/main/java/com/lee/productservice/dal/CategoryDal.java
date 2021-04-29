package com.lee.productservice.dal;

import com.lee.productservice.entity.Category;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:21
 */
public interface CategoryDal {
    void saveCategory(Category category);

    long count();

    List<Category> listCategory();

    List<Category> listCategoryPaginated(long pageNumber, int pageSize);

    Category getCategoryById(String id);

    void deleteCategory(String id);
}

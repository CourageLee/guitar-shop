package com.lee.productservice.service.impl;

import com.lee.productservice.dal.CategoryDal;
import com.lee.productservice.entity.Category;
import com.lee.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/4/23 10:24
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryDal categoryDal;

    @Override
    public void saveCategory(Category category) {
        if (category.getCreateTime() == null) {
            category.setCreateTime(new Date());
        }

        category.setUpdateTime(new Date());

        // TODO 获取创建人信息
        if (category.getCreatorId() == null) {
            category.setCreatorId("admin");
        }
        categoryDal.saveCategory(category);
    }

    @Override
    public long count() {
        return categoryDal.count();
    }

    @Override
    public List<Category> listCategory() {
        return categoryDal.listCategory();
    }

    @Override
    public List<Category> listCategoryPaginated(long pageNumber, int pageSize) {
        return categoryDal.listCategoryPaginated(pageNumber, pageSize);
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryDal.getCategoryById(id);
    }

    @Override
    public void deleteCategory(String id) {
        categoryDal.deleteCategory(id);
    }

    @Override
    public void updateCategory(String id, Category newCategory) {
        Category oldCategory = getCategoryById(id);
        newCategory.setId(oldCategory.getId());
        newCategory.setCreateTime(oldCategory.getCreateTime());
        // TODO 获取修改人信息
        newCategory.setCreatorId("admin");
        newCategory.setUpdateTime(new Date());

        saveCategory(newCategory);
    }
}

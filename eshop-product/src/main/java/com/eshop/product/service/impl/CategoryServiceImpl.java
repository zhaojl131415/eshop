package com.eshop.product.service.impl;

import com.eshop.product.entity.Category;
import com.eshop.product.mapper.CategoryMapper;
import com.eshop.product.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public void insert(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(Long id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
}

package com.eshop.product.service;

import com.eshop.product.entity.Category;

public interface CategoryService {
    void insert(Category category);

    void update(Category category);

    void delete(Long id);

    Category findById(Long id);
}

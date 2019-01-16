package com.eshop.product.service;

import com.eshop.product.entity.ProductProperty;

public interface ProductPropertyService {
    void insert(ProductProperty product);

    void update(ProductProperty product);

    void delete(Long id);

    ProductProperty findById(Long id);
}

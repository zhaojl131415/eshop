package com.eshop.product.service;

import com.eshop.product.entity.Product;

public interface ProductService {
    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);
}

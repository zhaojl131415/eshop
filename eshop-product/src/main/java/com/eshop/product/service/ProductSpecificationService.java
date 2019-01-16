package com.eshop.product.service;

import com.eshop.product.entity.ProductSpecification;

public interface ProductSpecificationService {
    void insert(ProductSpecification product);

    void update(ProductSpecification product);

    void delete(Long id);

    ProductSpecification findById(Long id);
}

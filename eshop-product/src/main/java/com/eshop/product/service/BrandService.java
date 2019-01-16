package com.eshop.product.service;

import com.eshop.product.entity.Brand;

public interface BrandService {
    void insert(Brand brand);

    void update(Brand brand);

    void delete(Long id);

    Brand findById(Long id);
}

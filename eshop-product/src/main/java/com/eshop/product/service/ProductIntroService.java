package com.eshop.product.service;

import com.eshop.product.entity.ProductIntro;

public interface ProductIntroService {
    void insert(ProductIntro product);

    void update(ProductIntro product);

    void delete(Long id);

    ProductIntro findById(Long id);
}

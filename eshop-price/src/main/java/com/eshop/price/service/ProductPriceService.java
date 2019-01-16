package com.eshop.price.service;

import com.eshop.price.entity.ProductPrice;

public interface ProductPriceService {
    void insert(ProductPrice product);

    void update(ProductPrice product);

    void delete(Long id);

    ProductPrice findById(Long id);
}

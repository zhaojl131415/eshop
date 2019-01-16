package com.eshop.inventory.service;

import com.eshop.inventory.entity.ProductInventory;

public interface ProductInventoryService {
    void insert(ProductInventory product);

    void update(ProductInventory product);

    void delete(Long id);

    ProductInventory findById(Long id);
}

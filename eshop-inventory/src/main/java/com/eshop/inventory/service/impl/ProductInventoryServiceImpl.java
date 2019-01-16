package com.eshop.inventory.service.impl;

import com.eshop.inventory.entity.ProductInventory;
import com.eshop.inventory.mapper.ProductInventoryMapper;
import com.eshop.inventory.service.ProductInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Resource
    private ProductInventoryMapper productInventoryMapper;

    @Override
    public void insert(ProductInventory productInventory) {
        productInventoryMapper.insert(productInventory);
    }

    @Override
    public void update(ProductInventory productInventory) {
        productInventoryMapper.update(productInventory);
    }

    @Override
    public void delete(Long id) {
        productInventoryMapper.delete(id);
    }

    @Override
    public ProductInventory findById(Long id) {
        return productInventoryMapper.findById(id);
    }
}

package com.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.inventory.entity.ProductInventory;
import com.eshop.inventory.mapper.ProductInventoryMapper;
import com.eshop.inventory.service.ProductInventoryService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Resource
    private ProductInventoryMapper productInventoryMapper;

    @Resource
    private JedisPool jedisPool;

    @Override
    public void insert(ProductInventory productInventory) {
        productInventoryMapper.insert(productInventory);
        jedisPool.getResource().set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void update(ProductInventory productInventory) {
        productInventoryMapper.update(productInventory);
        jedisPool.getResource().set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void delete(Long id) {
        ProductInventory productInventory = findById(id);
        productInventoryMapper.delete(id);
        jedisPool.getResource().del("product_inventory_" + productInventory.getProductId());
    }

    @Override
    public ProductInventory findById(Long id) {
        return productInventoryMapper.findById(id);
    }
}

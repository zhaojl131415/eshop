package com.eshop.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.price.entity.ProductPrice;
import com.eshop.price.mapper.ProductPriceMapper;
import com.eshop.price.service.ProductPriceService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Resource
    private ProductPriceMapper productPriceMapper;
    @Resource
    private JedisPool jedisPool;

    @Override
    public void insert(ProductPrice productPrice) {
        productPriceMapper.insert(productPrice);
        jedisPool.getResource().set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        jedisPool.getResource().set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void delete(Long id) {
        ProductPrice productPrice = findById(id);
        productPriceMapper.delete(id);
        jedisPool.getResource().del("product_price_" + productPrice.getProductId());
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }
}

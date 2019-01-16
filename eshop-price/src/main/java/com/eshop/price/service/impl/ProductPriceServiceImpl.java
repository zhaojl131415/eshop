package com.eshop.price.service.impl;

import com.eshop.price.entity.ProductPrice;
import com.eshop.price.mapper.ProductPriceMapper;
import com.eshop.price.service.ProductPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Resource
    private ProductPriceMapper productPriceMapper;

    @Override
    public void insert(ProductPrice productPrice) {
        productPriceMapper.insert(productPrice);
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
    }

    @Override
    public void delete(Long id) {
        productPriceMapper.delete(id);
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }
}

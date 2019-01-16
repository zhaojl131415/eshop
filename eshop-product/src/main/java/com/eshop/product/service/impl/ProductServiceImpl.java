package com.eshop.product.service.impl;

import com.eshop.product.entity.Product;
import com.eshop.product.mapper.ProductMapper;
import com.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public void insert(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    @Override
    public void delete(Long id) {
        productMapper.delete(id);
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }
}

package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductProperty;
import com.eshop.product.mapper.ProductPropertyMapper;
import com.eshop.product.service.ProductPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Resource
    private ProductPropertyMapper productPropertyMapper;

    @Override
    public void insert(ProductProperty productProperty) {
        productPropertyMapper.insert(productProperty);
    }

    @Override
    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
    }

    @Override
    public void delete(Long id) {
        productPropertyMapper.delete(id);
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }
}

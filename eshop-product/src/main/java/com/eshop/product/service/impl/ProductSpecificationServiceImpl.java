package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductSpecification;
import com.eshop.product.mapper.ProductSpecificationMapper;
import com.eshop.product.service.ProductSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Resource
    private ProductSpecificationMapper productSpecificationMapper;

    @Override
    public void insert(ProductSpecification productSpecification) {
        productSpecificationMapper.insert(productSpecification);
    }

    @Override
    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
    }

    @Override
    public void delete(Long id) {
        productSpecificationMapper.delete(id);
    }

    @Override
    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }
}

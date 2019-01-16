package com.eshop.product.service.impl;

import com.eshop.product.entity.Brand;
import com.eshop.product.mapper.BrandMapper;
import com.eshop.product.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public void insert(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    @Override
    public void delete(Long id) {
        brandMapper.delete(id);
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }
}

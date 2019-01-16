package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductIntro;
import com.eshop.product.mapper.ProductIntroMapper;
import com.eshop.product.service.ProductIntroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Resource
    private ProductIntroMapper productIntroMapper;

    @Override
    public void insert(ProductIntro productIntro) {
        productIntroMapper.insert(productIntro);
    }

    @Override
    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
    }

    @Override
    public void delete(Long id) {
        productIntroMapper.delete(id);
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }
}

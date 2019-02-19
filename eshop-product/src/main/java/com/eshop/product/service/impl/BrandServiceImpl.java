package com.eshop.product.service.impl;

import com.eshop.product.entity.Brand;
import com.eshop.product.mapper.BrandMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(Brand brand) {
        brandMapper.insert(brand);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"brand\", \"id\": " + brand.getId() + "}");
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"brand\", \"id\": " + brand.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        brandMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"brand\", \"id\": " + id + "}");
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }
}

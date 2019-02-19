package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductSpecification;
import com.eshop.product.mapper.ProductSpecificationMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.ProductSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Resource
    private ProductSpecificationMapper productSpecificationMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(ProductSpecification productSpecification) {
        productSpecificationMapper.insert(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_specification\", \"id\": " + productSpecification.getId() + "}");
    }

    @Override
    public void update(ProductSpecification productSpecification) {
        productSpecificationMapper.update(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_specification\", \"id\": " + productSpecification.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        productSpecificationMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_specification\", \"id\": " + id + "}");
    }

    @Override
    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }
}

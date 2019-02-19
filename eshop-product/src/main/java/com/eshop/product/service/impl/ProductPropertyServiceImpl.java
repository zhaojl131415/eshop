package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductProperty;
import com.eshop.product.mapper.ProductPropertyMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.ProductPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Resource
    private ProductPropertyMapper productPropertyMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(ProductProperty productProperty) {
        productPropertyMapper.insert(productProperty);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_property\", \"id\": " + productProperty.getId() + "}");
    }

    @Override
    public void update(ProductProperty productProperty) {
        productPropertyMapper.update(productProperty);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_property\", \"id\": " + productProperty.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        productPropertyMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_property\", \"id\": " + id + "}");
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }
}

package com.eshop.product.service.impl;

import com.eshop.product.entity.Product;
import com.eshop.product.mapper.ProductMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(Product product) {
        productMapper.insert(product);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        productMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product\", \"id\": " + id + "}");
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }
}

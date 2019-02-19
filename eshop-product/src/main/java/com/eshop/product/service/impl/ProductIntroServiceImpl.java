package com.eshop.product.service.impl;

import com.eshop.product.entity.ProductIntro;
import com.eshop.product.mapper.ProductIntroMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.ProductIntroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Resource
    private ProductIntroMapper productIntroMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(ProductIntro productIntro) {
        productIntroMapper.insert(productIntro);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"product_intro\", \"id\": " + productIntro.getId() + "}");
    }

    @Override
    public void update(ProductIntro productIntro) {
        productIntroMapper.update(productIntro);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"product_intro\", \"id\": " + productIntro.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        productIntroMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"product_intro\", \"id\": " + id + "}");
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }
}

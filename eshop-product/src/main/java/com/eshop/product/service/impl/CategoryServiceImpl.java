package com.eshop.product.service.impl;

import com.eshop.product.entity.Category;
import com.eshop.product.mapper.CategoryMapper;
import com.eshop.product.rabbitmq.RabbitMQSender;
import com.eshop.product.rabbitmq.RabbitQueue;
import com.eshop.product.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insert(Category category) {
        categoryMapper.insert(category);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"category\", \"id\": " + category.getId() + "}");
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"category\", \"id\": " + category.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        categoryMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.DATE_CHANGE_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"category\", \"id\": " + id + "}");
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
}

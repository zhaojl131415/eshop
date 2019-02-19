package com.eshop.product.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitMQSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(String queue, String message) {
        this.rabbitTemplate.convertAndSend(queue, message);
    }

}

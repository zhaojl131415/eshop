package com.eshop.cart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get_cart/{userName}")
    public String getCart(@PathVariable("userName") String userName) {
        return String.format("这是%s的购物车，访问服务器端口为：%s", userName, port);
    }
}

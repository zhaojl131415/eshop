package com.eshop.orders.controller;

import com.eshop.api.clients.CartClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private CartClient cartClient;

//    @GetMapping()

}

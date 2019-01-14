package com.eshop.user.controller;

import com.eshop.api.clients.CartClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private CartClient cartClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get_cart_by_user/{userName}")
    public String getCartByUser(@PathVariable("userName") String userName) {
        return cartClient.getCart(userName) + "，user服务端口为：" + port;
    }
}

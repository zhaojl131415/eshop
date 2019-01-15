package com.eshop.user.controller;

import com.eshop.api.clients.CartClient;
import com.eshop.user.entity.User;
import com.eshop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Resource
//    private CartClient cartClient;
//
//    @Value("${server.port}")
//    private String port;
//
//    @GetMapping("/get_cart_by_user/{userName}")
//    public String getCartByUser(@PathVariable("userName") String userName) {
//        return cartClient.getCart(userName) + "，user服务端口为：" + port;
//    }

    @Resource
    private UserService userService;

    @GetMapping("/findAllUsers")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAllUsers();
    }
}

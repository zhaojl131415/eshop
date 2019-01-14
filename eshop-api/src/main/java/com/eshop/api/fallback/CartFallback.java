package com.eshop.api.fallback;

import com.eshop.api.clients.CartClient;
import org.springframework.stereotype.Component;

@Component
public class CartFallback implements CartClient {
    @Override
    public String getCart(String userName) {
        return String.format("%s的购物车接口访问异常，请稍后重试！");
    }
}

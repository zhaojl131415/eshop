package com.eshop.api.clients;

import com.eshop.api.fallback.CartFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eshop-cart", fallback = CartFallback.class)
public interface CartClient {

    @GetMapping("/cart/get_cart/{userName}")
    String getCart(@PathVariable("userName") String userName);
}

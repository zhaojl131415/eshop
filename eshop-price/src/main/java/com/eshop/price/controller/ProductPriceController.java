package com.eshop.price.controller;

import com.eshop.price.entity.ProductPrice;
import com.eshop.price.service.ProductPriceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

    @Resource
    private ProductPriceService productPriceService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(ProductPrice productPrice) {
        productPriceService.insert(productPrice);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(ProductPrice productPrice) {
        productPriceService.update(productPrice);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productPriceService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public ProductPrice findById(@PathVariable Long id) {
        return productPriceService.findById(id);
    }

}

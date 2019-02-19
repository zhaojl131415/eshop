package com.eshop.product.controller;

import com.eshop.product.entity.Product;
import com.eshop.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(Product product) {
        productService.insert(product);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(Product product) {
        productService.update(product);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productService.delete(id);
        return "success";
    }

    @GetMapping("/findById")
    public Product findById(Long id) {
        return productService.findById(id);
    }

}

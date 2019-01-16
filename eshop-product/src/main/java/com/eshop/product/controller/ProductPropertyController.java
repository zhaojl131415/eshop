package com.eshop.product.controller;

import com.eshop.product.entity.ProductProperty;
import com.eshop.product.service.ProductPropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

    @Resource
    private ProductPropertyService productPropertyService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(ProductProperty productProperty) {
        productPropertyService.insert(productProperty);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(ProductProperty productProperty) {
        productPropertyService.update(productProperty);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productPropertyService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public ProductProperty findById(@PathVariable Long id) {
        return productPropertyService.findById(id);
    }

}

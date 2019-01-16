package com.eshop.product.controller;

import com.eshop.product.entity.ProductSpecification;
import com.eshop.product.service.ProductSpecificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Resource
    private ProductSpecificationService productSpecificationService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(ProductSpecification productSpecification) {
        productSpecificationService.insert(productSpecification);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(ProductSpecification productSpecification) {
        productSpecificationService.update(productSpecification);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productSpecificationService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public ProductSpecification findById(@PathVariable Long id) {
        return productSpecificationService.findById(id);
    }

}

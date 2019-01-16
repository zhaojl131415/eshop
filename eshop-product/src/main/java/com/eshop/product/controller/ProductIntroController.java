package com.eshop.product.controller;

import com.eshop.product.entity.ProductIntro;
import com.eshop.product.service.ProductIntroService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

    @Resource
    private ProductIntroService productIntroService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(ProductIntro productIntro) {
        productIntroService.insert(productIntro);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(ProductIntro productIntro) {
        productIntroService.update(productIntro);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productIntroService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public ProductIntro findById(@PathVariable Long id) {
        return productIntroService.findById(id);
    }

}

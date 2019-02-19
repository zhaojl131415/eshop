package com.eshop.product.controller;

import com.eshop.product.entity.Brand;
import com.eshop.product.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(Brand brand) {
        brandService.insert(brand);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(Brand brand) {
        brandService.update(brand);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        brandService.delete(id);
        return "success";
    }

    @GetMapping("/findById")
    public Brand findById(Long id) {
        return brandService.findById(id);
    }

}

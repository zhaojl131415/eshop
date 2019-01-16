package com.eshop.inventory.controller;

import com.eshop.inventory.entity.ProductInventory;
import com.eshop.inventory.service.ProductInventoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryController {

    @Resource
    private ProductInventoryService productInventoryService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(ProductInventory productInventory) {
        productInventoryService.insert(productInventory);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(ProductInventory productInventory) {
        productInventoryService.update(productInventory);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        productInventoryService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public ProductInventory findById(@PathVariable Long id) {
        return productInventoryService.findById(id);
    }

}

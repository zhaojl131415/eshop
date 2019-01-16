package com.eshop.product.controller;

import com.eshop.product.entity.Category;
import com.eshop.product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/insert")
    @ResponseBody
    public String insert(Category category) {
        categoryService.insert(category);
        return "success";
    }


    @PostMapping("/update")
    @ResponseBody
    public String update(Category category) {
        categoryService.update(category);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        categoryService.delete(id);
        return "success";
    }

    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

}

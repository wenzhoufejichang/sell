package com.hzm.web;

import com.hzm.daomain.Category;
import com.hzm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Integer add(String category_name) {

        Category category = new Category();
        category.setCategory_name(category_name);
        int i = categoryService.add(category);
        return i;

    }

    @GetMapping("/get/{id}")
    public Category get(@PathVariable("id") Integer id) {

        Category category = categoryService.get(id);
        return category;

    }


}

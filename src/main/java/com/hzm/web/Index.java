package com.hzm.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hzm.daomain.Category;
import com.hzm.service.CategoryService;
import com.hzm.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/cookie")
    public String addcookie(HttpServletResponse httpServletResponse) {

        Cookie c = new Cookie("openid", "12");

        c.setDomain("sell.com");
        //c.setPath("/");
        c.setMaxAge(43200);
        httpServletResponse.addCookie(c);
        return null;
    }


    @GetMapping("/get/{id}")
    public Category get(@PathVariable("id") Integer id) {
        Category category = categoryService.get(id);
        return category;

    }

    @PutMapping("/put")
    public int put(Category category) {
        category.setUpdate_time(new Date());
        int put = categoryService.put(category);
        return put;

    }

    @GetMapping("/buyer/product/list")
    public Results<Category> list() throws JsonProcessingException {

        List<Category> list = categoryService.list();
        Results<Category> results = new Results<>();

        results.setCode(0);
        results.setMsg("成功");
        results.setData(list);

        //FilterProvider filterProvider = new SimpleFilterProvider();


        return results;

    }


}

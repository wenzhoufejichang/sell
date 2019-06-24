package com.hzm.service.impl;

import com.hzm.dao.CategoryInterface;
import com.hzm.daomain.Category;
import com.hzm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryInterface categoryInterface;

    @Transactional
    @Override
    public int add(Category category) {


        return categoryInterface.insert(category);
    }
    @Transactional
    @Override
    public List<Category> list() {


       // PageHelper.startPage(pager, rows);

        List<Category> all = categoryInterface.findAll();

        return all;
    }

    @Transactional(readOnly = true)
    @Override
    public Category get(Integer id) {
        return categoryInterface.get(id);
    }

    @Transactional
    @Override
    public int put(Category category) {
        return categoryInterface.update(category);
    }


}

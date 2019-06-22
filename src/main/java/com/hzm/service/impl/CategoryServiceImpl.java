package com.hzm.service.impl;

import com.hzm.dao.CategoryInterface;
import com.hzm.daomain.Category;
import com.hzm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryInterface categoryInterface;

    @Transactional
    @Override
    public int add(Category category) {


        return categoryInterface.insert(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Category get(Integer id) {
        return categoryInterface.get(id);
    }


}

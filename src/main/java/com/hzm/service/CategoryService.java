package com.hzm.service;

import com.hzm.daomain.Category;

import java.util.List;

public interface CategoryService {

    public abstract int add(Category category);
    public abstract List<Category> list();

    public abstract Category get(Integer id);
    public abstract int put(Category category);


}

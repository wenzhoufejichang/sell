package com.hzm.service;

import com.hzm.daomain.Category;

public interface CategoryService {

    public abstract int add(Category category);


    public abstract Category get(Integer id);

}

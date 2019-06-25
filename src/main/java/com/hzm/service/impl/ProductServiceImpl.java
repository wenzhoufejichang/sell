package com.hzm.service.impl;

import com.hzm.dao.ProductInterface;
import com.hzm.daomain.Product;
import com.hzm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInterface productInterface;


    @Override
    public Product findByProductId(String id) {
        return productInterface.findByProductId(id);
    }
}

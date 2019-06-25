package com.hzm.service.impl;

import com.hzm.dao.Order_DetailsInterface;
import com.hzm.dao.Order_MasterInterface;
import com.hzm.dao.ProductInterface;
import com.hzm.daomain.Order_Master;
import com.hzm.daomain.Order_details;
import com.hzm.daomain.Product;
import com.hzm.exception.Insufficient_Product;
import com.hzm.service.Order_Master_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Order_Maser_ServiceImpl implements Order_Master_service {

    @Autowired
    private Order_MasterInterface order_masterInterface;
    @Autowired
    private Order_DetailsInterface order_detailsInterface;
    @Autowired
    private ProductInterface productInterface;

    @Override
    @Transactional
    public void add(Order_Master order_master, List<Order_details> list) {


        order_masterInterface.insert(order_master);


        list.stream().forEach(order_details -> {

            order_details.setOrder_id(order_master);
            order_detailsInterface.insert(order_details);

            String product_id = order_details.getProduct_id();

            Product product = productInterface.findByProductId(product_id);


            if (product.getProduct_store() - order_details.getProduct_number() < 0) {


                throw new Insufficient_Product("商品库存不足");
            } else {


                productInterface.updateProductstore(order_details.getProduct_number());


            }
        });

    }
}

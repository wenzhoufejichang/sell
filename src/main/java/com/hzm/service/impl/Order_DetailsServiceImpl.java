package com.hzm.service.impl;

import com.hzm.dao.Order_DetailsInterface;
import com.hzm.dao.ProductInterface;
import com.hzm.daomain.Order_details;
import com.hzm.daomain.Product;
import com.hzm.exception.NotExist_Product;
import com.hzm.service.Order_details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class Order_DetailsServiceImpl implements Order_details_Service {

    @Autowired
    private Order_DetailsInterface order_detailsInterface;
    @Autowired
    private ProductInterface productInterface;

    @Override
    public int add(Order_details order_details) {
        return 0;
    }

    @Transactional
    @Override
    public List<Order_details> findByProductIds(List<Order_details> list) {
        list.stream().forEach(order_details -> {

            String product_id = order_details.getProduct_id();
            Product byProductId = productInterface.findByProductId(product_id);


            if(Objects.isNull(byProductId)){
                throw new NotExist_Product("商品不存在");
            }


            order_details.setProduct_image(byProductId.getProduct_image());
            order_details.setProduct_price(byProductId.getProduct_price());
            order_details.setProduct_name(byProductId.getProduct_name());
        });


        return list;
    }
}

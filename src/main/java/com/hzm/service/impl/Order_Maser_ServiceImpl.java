package com.hzm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hzm.dao.Order_DetailsInterface;
import com.hzm.dao.Order_MasterInterface;
import com.hzm.dao.ProductInterface;
import com.hzm.daomain.Order_Master;
import com.hzm.daomain.Order_details;
import com.hzm.daomain.Product;
import com.hzm.exception.Insufficient_Product;
import com.hzm.exception.NotExist_Product;
import com.hzm.service.Order_Master_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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


                productInterface.updateProductstore(order_details);


            }
        });

    }

    @Transactional
    @Override
    public List<Order_Master> list(int start, String rows) {


        PageHelper.startPage(start, Integer.parseInt(rows));

        List<Order_Master> all = order_masterInterface.findAll();

        return all;
    }

    @Transactional
    @Override
    public Order_Master details(Order_Master order_master) {


        return order_masterInterface.findByOrderid(order_master);
    }

    @Transactional
    @Override
    public void cacle(Order_Master order_master) {

        //查询订单详情
        List<Order_details> orderidlist = order_detailsInterface.findByOrderidlist(order_master.getOrder_id());
        if (Objects.isNull(orderidlist) || orderidlist.size() == 0) {

            throw new NotExist_Product("订单不存在");
        }
        //会填商品库存
        orderidlist.stream().forEach(order_details -> {
            productInterface.updateaddProductstore(order_details);
            //删除订单详情
            order_detailsInterface.delete(order_details.getDetail_id());

        });
        //查询订单总表
        Order_Master byOrderid2 = order_masterInterface.findByOrderid2(order_master);

        if (Objects.isNull(byOrderid2)) {
            throw new NotExist_Product("订单总表不存在");
        }
        //删除订单总表
        order_masterInterface.delete(order_master);

        //返回现金
        //TODO
    }
}

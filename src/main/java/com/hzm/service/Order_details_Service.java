package com.hzm.service;

import com.hzm.daomain.Order_details;

import java.util.List;

public interface Order_details_Service {

    public abstract int add(Order_details order_details);

    public abstract List<Order_details> findByProductIds(List<Order_details> list);
}

package com.hzm.service;

import com.hzm.daomain.Order_Master;
import com.hzm.daomain.Order_details;

import java.util.List;

public interface Order_Master_service {



    public abstract void add(Order_Master order_master, List<Order_details> list);

}

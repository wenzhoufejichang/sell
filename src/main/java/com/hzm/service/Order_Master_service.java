package com.hzm.service;

import com.hzm.daomain.Order_Master;
import com.hzm.daomain.Order_details;

import java.util.List;

public interface Order_Master_service {


    public abstract void add(Order_Master order_master, List<Order_details> list);

    public abstract List<Order_Master> list(int start, String rows);


    public abstract Order_Master details(Order_Master order_master);



    public abstract void cacle(Order_Master order_master);

}

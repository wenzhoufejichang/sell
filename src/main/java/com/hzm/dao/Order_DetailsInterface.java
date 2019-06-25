package com.hzm.dao;

import com.hzm.daomain.Order_details;
import org.apache.ibatis.annotations.Insert;

public interface Order_DetailsInterface {

    @Insert("insert into order_details (detail_id,order_id,product_id,product_name,product_price,product_number,product_image,update_time)" +
            "values(uuid() ,#{order_id.order_id},#{product_id},#{product_name},#{product_price},#{product_number}," +
            "#{product_image},#{update_time})")
    public abstract int insert(Order_details order_details);


}

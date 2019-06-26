package com.hzm.dao;

import com.hzm.daomain.Order_details;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Order_DetailsInterface {

    @Insert("insert into order_details (detail_id,order_id,product_id,product_name,product_price,product_number,product_image,update_time)" +
            "values(uuid() ,#{order_id.order_id},#{product_id},#{product_name},#{product_price},#{product_number}," +
            "#{product_image},#{update_time})")
    public abstract int insert(Order_details order_details);

    @Select(" select detail_id,order_id,product_id,product_name,product_price,product_number,product_image from order_details where order_id=#{order_id}")
    public abstract Order_details findByOrderid_(String id);

    @Select(" select * from order_details where order_id=#{order_id}")
    public abstract List<Order_details> findByOrderidlist(String id);

    @Delete(" delete FROM order_details where detail_id =#{value}")
    public abstract void delete(String id);

}

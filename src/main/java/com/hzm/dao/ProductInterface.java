package com.hzm.dao;

import com.hzm.daomain.Order_details;
import com.hzm.daomain.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductInterface {
    @Select(" select product_id,product_name,product_price, product_desc,product_image from product_info where category_id=#{category_id}")
    public abstract Product findByCategoryId(Integer id);

    @Select(" select * from product_info where product_id=#{product_id}")
    public abstract Product findByProductId(String id);


    @Update("update product_info set product_store=product_store-#{product_number} where product_id=#{product_id} ")
    public abstract void updateProductstore( Order_details order_details);

    @Update("update product_info set product_store=product_store+#{product_number} where product_id=#{product_id} ")
    public abstract void updateaddProductstore( Order_details order_details);


}

package com.hzm.dao;

import com.hzm.daomain.Product;
import org.apache.ibatis.annotations.Select;

public interface ProductInterface {
    @Select(" select product_id,product_name,product_price, product_desc,product_image from product_info where category_id=#{category_id}")
    public abstract Product findByCategory(Integer id);

}

package com.hzm.dao;

import com.hzm.daomain.Order_Master;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface Order_MasterInterface {

    @Insert("insert into order_master (order_id,buy_name,buy_phone,buy_address,buy_openid,total_order_amount,update_time)" +
            "values(#{order_id},#{buy_name},#{buy_phone},#{buy_address},#{buy_openid},#{total_order_amount}," +
            "#{update_time})")
    @SelectKey(before = true, keyProperty = "order_id", resultType = String.class, statement = {"select uuid()"})
    public abstract int insert(Order_Master order_master);


}

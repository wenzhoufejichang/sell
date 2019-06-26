package com.hzm.dao;

import com.hzm.daomain.Order_Master;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface Order_MasterInterface {

    @Insert("insert into order_master (order_id,buy_name,buy_phone,buy_address,buy_openid,total_order_amount,update_time)" +
            "values(#{order_id},#{buy_name},#{buy_phone},#{buy_address},#{buy_openid},#{total_order_amount}," +
            "#{update_time})")
    @SelectKey(before = true, keyProperty = "order_id", resultType = String.class, statement = {"select uuid()"})
    public abstract int insert(Order_Master order_master);


    @Select("select * from order_master")
    public abstract List<Order_Master> findAll();

    @Select("select *  from order_master where order_id=#{order_id} and buy_openid=#{buy_openid} ")
    @Results(value = {@Result(id = true, column = "order_id", property = "order_id"),
            @Result(column = "buy_name", property = "buy_name"),
            @Result(column = "buy_phone", property = "buy_phone"),
            @Result(column = "buy_address", property = "buy_address"),
            @Result(column = "buy_openid", property = "buy_openid"),
            @Result(column = "total_order_amount", property = "total_order_amount"),
            @Result(column = "order_status", property = "order_status"),
            @Result(column = "pay_status", property = "pay_status"),
            @Result(column = "create_time", property = "create_time"),
            @Result(column = "update_time", property = "update_time"),
            //一对多建议懒加载			//主表的主键字段给select = "findByL"提供值
            @Result(many = @Many(select = "com.hzm.dao.Order_DetailsInterface.findByOrderid_", fetchType = FetchType.LAZY), column = "order_id", property = "set")})
    public abstract Order_Master findByOrderid(Order_Master order_master);

    @Select("select order_id from order_master where buy_openid =#{buy_openid } and order_id=#{order_id}")
    public abstract Order_Master findByOrderid2(Order_Master order_master);

    @Delete("delete FROM order_master where buy_openid =#{buy_openid } and order_id=#{order_id}")
    public abstract void delete(Order_Master order_master);
}

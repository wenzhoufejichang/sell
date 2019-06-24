package com.hzm.dao;

import com.hzm.daomain.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CategoryInterface {
    @Insert("insert into category (category_name) values(#{category_name})")
    @SelectKey(before = false, keyProperty = "category_id", resultType = Integer.class, statement = {" SELECT LAST_INSERT_ID()"})
    public abstract int insert(Category category);

    @Select("select * from category where category_id=#{category_id}")
    public abstract Category get(Integer id);

    @Update("update category set category_name=#{category_name} ,update_time=#{update_time} where category_id=#{category_id}")
    public abstract int update(Category category);

    @Select("select category_id ,category_name from category")
    @Results(value = {@Result(id = true, column = "category_id", property = "category_id"),
            @Result(column = "category_name", property = "category_name"),
                                        //一对多建议懒加载			//主表的主键字段给select = "findByL"提供值
            @Result(many = @Many(select = "com.hzm.dao.ProductInterface.findByCategory", fetchType = FetchType.LAZY), column = "category_id", property = "set")})
    public abstract List<Category> findAll();

}
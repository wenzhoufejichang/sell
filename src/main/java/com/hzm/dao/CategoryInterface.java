package com.hzm.dao;

import com.hzm.daomain.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface CategoryInterface {
    @Insert("insert into category (category_name) values(#{category_name})")
    @SelectKey(before = false, keyProperty = "category_id", resultType = Integer.class, statement = {" SELECT LAST_INSERT_ID()"})
    public abstract int insert(Category category);

    @Select("select * from category where category_id=#{category_id}")
    public abstract Category get(Integer id);
}
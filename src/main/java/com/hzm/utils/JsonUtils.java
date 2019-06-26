package com.hzm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JsonUtils {


    public static ObjectMapper getonObjectMapper(String filterName, String... value) {



        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilterProvider(new SimpleFilterProvider().addFilter(filterName,
                SimpleBeanPropertyFilter.serializeAllExcept(value)));


        return mapper;


    }

}

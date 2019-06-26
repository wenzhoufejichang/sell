package com.hzm.vo;


import lombok.Data;

@Data
public class OrderRestlt<T> {

    private int code;
    private String msg;

    private T data;





}

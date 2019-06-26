package com.hzm.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeEum {
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    Insufficient(2, "商品不足"),
    NOORDEREXIST(4, "订单不存在"),
    NOOKNOW(5, "未知错误"),
    NOTEXIST(3, "商品不存在");
    private int code;
    private String message;


}

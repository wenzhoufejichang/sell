package com.hzm.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodeEum {
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    Insufficient(2,"商品不存在"),
    NOTEXIST(3,"商品不足");
    private int code;
    private String message;


}

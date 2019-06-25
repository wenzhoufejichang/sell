package com.hzm.daomain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"handler"})
@JsonFilter("Order_Master")
public class Order_Master {

    //    CREATE TABLE `order_master` (
//            `order_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
//            `buy_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '买家名称',
//            `buy_phone` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '买家电话',
//            `buy_address` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '买家地址',
//            `buy_openid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '买家id',
//            `total_order_amount` double(8,2) NOT NULL DEFAULT '0.00' COMMENT '订单总金额',
//            `order_status` int(11) DEFAULT '0' COMMENT '订单状态 0为新订单',
//            `pay_status` int(11) DEFAULT '0' COMMENT '支付状态 0为未支付',
//            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
//    PRIMARY KEY (`order_id`),
//    KEY `buy_openid` (`buy_openid`)
//            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
    private String order_id;
    private String buy_name;

    private String buy_phone;
    private String buy_address;
    private String buy_openid;
    private Double total_order_amount;
    private int order_status;
    private int pay_status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;




}

package com.hzm.daomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"handler"})
//@JsonFilter("no")
public class Order_details {

//    CREATE TABLE `order_details` (
//            `detail_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
//            `order_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
//  `product_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
//            `product_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
//            `product_price` double(7,2) NOT NULL COMMENT '单价',
//            `product_number` int(11) NOT NULL COMMENT '数量',
//            `product_image` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
//            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
//    PRIMARY KEY (`detail_id`),
//    KEY `order_details_order_id` (`order_id`),
//    CONSTRAINT `order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`order_id`)
//            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

    private String detail_id;
    private Order_Master order_id;

    private String product_id;
    private String product_name;
    private Double product_price;
    private int product_number;
    private String product_image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date update_time;
}

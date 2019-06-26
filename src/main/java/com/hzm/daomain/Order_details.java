package com.hzm.daomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"handler"})
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
    @JsonProperty("detailId")
    private String detail_id;
    @JsonProperty("orderId")
    private Order_Master order_id;
    @JsonProperty("productId")
    private String product_id;
    @JsonProperty("productName")
    private String product_name;
    @JsonProperty("productPrice")
    private Double product_price;
    @JsonProperty("productQuantity")
    private int product_number;
    @JsonProperty("productIcon")
    private String product_image;
    //@JsonProperty("productId")
    private Date create_time;
    //@JsonProperty("productId")
    private Date update_time;
}

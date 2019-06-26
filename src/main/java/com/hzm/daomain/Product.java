package com.hzm.daomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = {"handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {


//    CREATE TABLE `product_info` (
//            `product_id` VARCHAR (32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
//            `product_name` VARCHAR (64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
//            `product_price` DOUBLE (7, 2) NOT NULL COMMENT '单价',
//            `product_store` INT (11) NOT NULL COMMENT '库存',
//            `product_desc` VARCHAR (128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
//            `product_image` VARCHAR (512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
//            `category_id` INT (11) NOT NULL COMMENT '类目',
//            `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//            `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
//    PRIMARY KEY (`product_id`),
//    KEY `product_info_category_id` (`category_id`),
//    CONSTRAINT `product_info_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
//            ) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

    @JsonProperty("id")
    private String product_id;
    @JsonProperty("name")
    private String product_name;
     @JsonProperty("price")
    private Double product_price;
    private Integer product_store;
    @JsonProperty("description")
    private String product_desc;
    @JsonProperty("icon")
    private String product_image;
    private Category category_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id) &&
                Objects.equals(product_name, product.product_name) &&
                Objects.equals(product_price, product.product_price) &&
                Objects.equals(product_store, product.product_store) &&
                Objects.equals(product_desc, product.product_desc) &&
                Objects.equals(product_image, product.product_image) &&
                Objects.equals(create_time, product.create_time) &&
                Objects.equals(update_time, product.update_time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), product_id, product_name, product_price, product_store, product_desc, product_image, create_time, update_time);
    }
}

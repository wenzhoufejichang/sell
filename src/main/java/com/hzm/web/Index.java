package com.hzm.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzm.utils.JsonUtils;
import com.hzm.daomain.Category;
import com.hzm.daomain.Order_Master;
import com.hzm.daomain.Order_details;
import com.hzm.eum.CodeEum;
import com.hzm.exception.Insufficient_Product;
import com.hzm.exception.NotExist_Product;
import com.hzm.service.CategoryService;
import com.hzm.service.Order_Master_service;
import com.hzm.service.Order_details_Service;
import com.hzm.service.ProductService;
import com.hzm.vo.OrderRestlt;
import com.hzm.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class Index {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Order_Master_service order_master_service;

    @Autowired
    private ProductService productService;
    @Autowired
    private Order_details_Service order_details_service;

    @PostMapping("/add")
    public Integer add(String category_name) {

        Category category = new Category();
        category.setCategory_name(category_name);
        int i = categoryService.add(category);
        return i;

    }

    @GetMapping("/cookie")
    public String addcookie(HttpServletResponse httpServletResponse) {

        Cookie c = new Cookie("openid", "12");

        c.setDomain("sell.com");
        //c.setPath("/");
        c.setMaxAge(43200);
        httpServletResponse.addCookie(c);
        return null;
    }


    @GetMapping("/get/{id}")
    public Category get(@PathVariable("id") Integer id) {
        Category category = categoryService.get(id);
        return category;

    }

    @PutMapping("/put")
    public int put(Category category) {
        category.setUpdate_time(new Date());
        int put = categoryService.put(category);
        return put;

    }

    @GetMapping("/buyer/product/list")
    public Results<Category> list() {

        List<Category> list = categoryService.list();
        Results<Category> results = new Results<>();

        results.setCode(CodeEum.SUCCESS.getCode());
        results.setMsg(CodeEum.SUCCESS.getMessage());
        results.setData(list);

        return results;

    }

    @PostMapping(value = "/buyer/order/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String buy(@RequestParam String name, @RequestParam String phone, @RequestParam String

            address, @RequestParam String openid, String[] productId, String[] productQuantity) {

//        name: "张三"
//        phone: "18868822111"
//        address: "慕课网总部"
//        openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
        List<Order_details> list = new ArrayList<>();
        Order_Master order_master = new Order_Master(null, name, phone, address, openid, null, 0, 0, null, null);
        for (int i = 0; i < productId.length; i++) {
            Order_details order_detail = new Order_details();
            order_detail.setProduct_id(productId[i]);
            order_detail.setProduct_number(Integer.parseInt(productQuantity[i]));
            list.add(order_detail);

        }
        OrderRestlt<Order_Master> order_masterOrderRestlt = new OrderRestlt<>();
        String writeValueAsString = null;
        try {
            List<Order_details> byProductIds = order_details_service.findByProductIds(list);
            BigDecimal bigDecimal = BigDecimal.valueOf(0);

            for (Order_details order_details : byProductIds) {
                BigDecimal multiply = BigDecimal.valueOf(order_details.getProduct_price()).multiply(BigDecimal.valueOf(order_details
                        .getProduct_number()));
                bigDecimal = bigDecimal.add(multiply);
            }
            order_master.setTotal_order_amount(bigDecimal.doubleValue());




            order_master_service.add(order_master, byProductIds);
            order_masterOrderRestlt.setCode(CodeEum.SUCCESS.getCode());
            order_masterOrderRestlt.setMsg(CodeEum.SUCCESS.getMessage());
            order_masterOrderRestlt.setData(order_master);


            String[] value = {"buy_name", "buy_phone", "update_time", "buy_address", "buy_openid",
                    "total_order_amount", "order_status", "pay_status", "create_time"};

            ObjectMapper objectMapper = JsonUtils.getonObjectMapper("Order_Master", value);
            writeValueAsString = objectMapper.writeValueAsString(order_masterOrderRestlt);

        } catch (Exception e) {

            e.printStackTrace();


            if (e.getClass() == NotExist_Product.class) {


                order_masterOrderRestlt.setCode(CodeEum.NOTEXIST.getCode());
                order_masterOrderRestlt.setMsg(CodeEum.NOTEXIST.getMessage());
            } else if (e.getClass() == Insufficient_Product.class) {

                order_masterOrderRestlt.setCode(CodeEum.Insufficient.getCode());
                order_masterOrderRestlt.setMsg(CodeEum.Insufficient.getMessage());

            } else {


                order_masterOrderRestlt.setCode(CodeEum.ERROR.getCode());
                order_masterOrderRestlt.setMsg(CodeEum.ERROR.getMessage());
            }

            order_masterOrderRestlt.setData(null);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                writeValueAsString = objectMapper.writeValueAsString(order_masterOrderRestlt);
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        }
        return writeValueAsString;

    }

}

package com.ttyc.redis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private Long id;

    private String orderSn;

    private String name;

    private Integer status;

    private Double price;

    private Date createTime;

    private Date updateTime;


}
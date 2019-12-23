package com.ttyc.redis;

import com.ttyc.redis.entity.Order;
import com.ttyc.redis.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest(classes = RedisApplication.class)
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate() {
        Order order = new Order();
        order.setOrderSn("20194548");
        order.setName("手机");
        order.setPrice(10001.1);
        order.setStatus(0);
        order.setCreateTime(new Date());

        orderService.create(order);
    }

    @Test
    public void testGet() {
        Order order = orderService.get(1L);
        Assert.isTrue(order != null, "error");
    }
}

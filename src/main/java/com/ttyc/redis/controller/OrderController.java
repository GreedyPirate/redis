package com.ttyc.redis.controller;

import com.ttyc.redis.entity.Order;
import com.ttyc.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public Boolean create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("{id}")
    public Order get(@PathVariable Long id) {
        return orderService.get(id);
    }
}

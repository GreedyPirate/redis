package com.ttyc.redis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ttyc.redis.dao.OrderMapper;
import com.ttyc.redis.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrderService {

    private static final String KEY_PREFIX = "order_";

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Boolean create(Order order) {
        orderMapper.insertSelective(order);
        return true;
    }

    public Order get(Long id) {
        Object order = redisTemplate.opsForHash().get(KEY_PREFIX + id, "");
        return orderMapper.selectByPrimaryKey(id);
    }
}

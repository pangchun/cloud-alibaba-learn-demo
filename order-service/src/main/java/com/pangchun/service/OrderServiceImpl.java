package com.pangchun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangchun.entity.Order;
import com.pangchun.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
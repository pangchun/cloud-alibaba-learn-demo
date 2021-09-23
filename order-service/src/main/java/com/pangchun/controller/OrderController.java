package com.pangchun.controller;

import com.pangchun.entity.Order;
import com.pangchun.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/get")
    public Order get() {
        Order order = orderService.getById(1);
        System.out.println(order.toString());
        return order;
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        // save()方法会自动回填主键id
        boolean flag = orderService.save(order);
        System.out.println(order);
        return order;
    }
}
package com.leosantos.restaurante.api.restaurante_api_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.OrdersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.services.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public boolean create(@RequestBody OrdersEntity order) {
        return this.ordersService.create(order);
    }

    @GetMapping
    public List<OrdersEntity> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        return this.ordersService.findAll(page, limit).getContent();
    }
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.OrdersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.repositories.OrdersRepository;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public boolean create(OrdersEntity order) {
        ordersRepository.save(order);
        return true;
    }

    public Page<OrdersEntity> findAll(Integer page, Integer limit) {
        int safePage = (page == null || page < 1) ? 1 : page;
        int safeLimit = (limit == null || limit < 1) ? 10 : limit;
        safeLimit = Math.min(safeLimit, 100);

        Pageable pageable = PageRequest.of(
                safePage - 1,
                safeLimit,
                Sort.by(Sort.Direction.DESC, "createdAt"));

        return ordersRepository.findAll(pageable);
    }
}

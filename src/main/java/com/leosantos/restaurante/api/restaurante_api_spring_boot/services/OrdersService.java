package com.leosantos.restaurante.api.restaurante_api_spring_boot.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.OrdersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.enums.OrderStatus;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.exception.OrdersNotExistsException;
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

    public Page<OrdersEntity> findAll(Integer limit) {
        int safeLimit = (limit == null || limit < 1) ? 10 : limit;
        safeLimit = Math.min(safeLimit, 100);

        Pageable pageable = PageRequest.of(
                0,
                safeLimit,
                Sort.by(Sort.Direction.DESC, "createdAt"));

        return ordersRepository.findAllByStatus(OrderStatus.IN_PROGRESS, pageable);
    }

    public boolean update(String id, OrdersEntity body) {
        OrdersEntity order = ordersRepository.findById(id).orElseThrow(() -> new OrdersNotExistsException(id));

        order.setTitle(body.getTitle());
        order.setDescription(body.getDescription());
        order.setStatus(body.getStatus());
        order.setUpdatedAt(LocalDateTime.now());

        ordersRepository.save(order);
        return true;
    }

    public boolean delete(String id) {
        if (!ordersRepository.existsById(id))
            return false;
        ordersRepository.deleteById(id);
        return true;
    }
}

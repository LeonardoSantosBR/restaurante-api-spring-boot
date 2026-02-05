package com.leosantos.restaurante.api.restaurante_api_spring_boot.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.OrdersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.enums.OrderStatus;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, String> {
    Page<OrdersEntity> findAllByStatus(OrderStatus status, Pageable pageable);
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.OrdersEntity;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, String> {
}

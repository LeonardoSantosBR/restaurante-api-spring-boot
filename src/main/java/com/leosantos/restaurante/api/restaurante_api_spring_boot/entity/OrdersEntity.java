package com.leosantos.restaurante.api.restaurante_api_spring_boot.entity;

import java.time.LocalDateTime;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public String orderNumber;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false, updatable = true)
    private LocalDateTime createdAt;

    @Column(nullable = true, updatable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = true, updatable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    public void createdAtPrePersist(){
        this.createdAt = LocalDateTime.now();
    }

    //getters
    public Long getId() {
        return id;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public OrderStatus getStatus() {
        return status;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public void getTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

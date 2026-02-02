package com.leosantos.restaurante.api.restaurante_api_spring_boot.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    private String id;

    @Column(name = "order_number", nullable = false, updatable = false, insertable = false)
    public Long orderNumber;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true, updatable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true, updatable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersists() {
        if (this.id == null) { // importante!
            this.id = UUID.randomUUID().toString();
        }
        this.createdAt = LocalDateTime.now();
    }

    // getters
    public String getId() {
        return id;
    }

    public Long getOrderNumber() {
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

    // setters
    public void setId(String id) {
        this.id = id;
    }

    public void setOrderNumber(Long orderNumber) {
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

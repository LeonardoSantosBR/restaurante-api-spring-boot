package com.leosantos.restaurante.api.restaurante_api_spring_boot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true, updatable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true, updatable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    public void createdAtPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeleteddAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}

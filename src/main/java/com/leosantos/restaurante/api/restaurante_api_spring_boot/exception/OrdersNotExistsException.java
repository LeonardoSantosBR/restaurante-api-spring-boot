package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

import org.springframework.http.HttpStatus;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.config.ApiException;

public class OrdersNotExistsException extends ApiException {
    public OrdersNotExistsException(String id) {
        super(HttpStatus.NOT_FOUND, "Não existe pedido com id: " + id);
    }
}

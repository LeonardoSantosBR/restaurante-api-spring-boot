package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

public class OrdersNotExistsException extends RuntimeException {
    public OrdersNotExistsException(String id) {
        super("Não existe pedido com id: " + id);
    }
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

import org.springframework.http.HttpStatus;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.config.ApiException;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
    }
}

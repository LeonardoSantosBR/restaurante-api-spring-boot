package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

import org.springframework.http.HttpStatus;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.config.ApiException;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String email) {
        super(HttpStatus.CONFLICT, "Já existe um usuário cadastrado com o email: " + email);
    }
}

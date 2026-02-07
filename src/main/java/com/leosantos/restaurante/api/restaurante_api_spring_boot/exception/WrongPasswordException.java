package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

import org.springframework.http.HttpStatus;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.config.ApiException;

public class WrongPasswordException extends ApiException {
    public WrongPasswordException() {
        super(HttpStatus.UNAUTHORIZED, "Senha Incorreta.");
    }
}

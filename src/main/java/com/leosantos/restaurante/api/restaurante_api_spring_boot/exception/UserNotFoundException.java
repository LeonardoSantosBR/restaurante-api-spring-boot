package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Usuário não encontrado.");
    }
}

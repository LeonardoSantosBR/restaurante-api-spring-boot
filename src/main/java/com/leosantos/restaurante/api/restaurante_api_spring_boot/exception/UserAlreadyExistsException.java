package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Já existe um usuário cadastrado com o email: " + email);
    }
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Senha Incorreta.");
    }
}

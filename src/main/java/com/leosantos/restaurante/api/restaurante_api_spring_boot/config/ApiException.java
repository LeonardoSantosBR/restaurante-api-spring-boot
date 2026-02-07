package com.leosantos.restaurante.api.restaurante_api_spring_boot.config;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
     private final HttpStatus status;

      protected ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

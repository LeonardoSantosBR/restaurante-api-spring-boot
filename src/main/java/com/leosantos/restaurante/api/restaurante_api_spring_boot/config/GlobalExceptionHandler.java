package com.leosantos.restaurante.api.restaurante_api_spring_boot.config;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ApiException.class)
        public ResponseEntity<?> handleApiException(ApiException ex) {
                return ResponseEntity
                                .status(ex.getStatus())
                                .body(Map.of(
                                                "timestamp", Instant.now(),
                                                "status", ex.getStatus().value(),
                                                "error", ex.getStatus().getReasonPhrase(),
                                                "message", ex.getMessage()));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleGeneric(Exception ex) {
                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Map.of(
                                                "timestamp", Instant.now(),
                                                "status", 500,
                                                "error", "Internal Server Error",
                                                "message", "Erro inesperado."));
        }
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.dto;

public class TokenDto {
    public Long id;
    public String name;
    public String email;

    public TokenDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

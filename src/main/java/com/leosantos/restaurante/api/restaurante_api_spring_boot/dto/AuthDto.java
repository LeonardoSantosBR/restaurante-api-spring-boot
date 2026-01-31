package com.leosantos.restaurante.api.restaurante_api_spring_boot.dto;

public class AuthDto {
    public String email;
    public String password;

    public AuthDto() {
    }

    // getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

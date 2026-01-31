package com.leosantos.restaurante.api.restaurante_api_spring_boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.dto.AuthDto;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.dto.SigninResponse;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping
    public SigninResponse signin(@RequestBody AuthDto body){
        return this.authService.signin(body.email, body.password);
    }
}

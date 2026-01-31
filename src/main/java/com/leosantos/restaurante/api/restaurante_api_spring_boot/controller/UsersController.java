package com.leosantos.restaurante.api.restaurante_api_spring_boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.UsersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    public boolean create(@RequestBody UsersEntity user){
        return this.usersService.create(user);
    }
}

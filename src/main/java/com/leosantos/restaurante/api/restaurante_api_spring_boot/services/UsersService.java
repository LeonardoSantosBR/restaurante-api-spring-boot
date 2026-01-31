package com.leosantos.restaurante.api.restaurante_api_spring_boot.services;

import org.springframework.stereotype.Service;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.UsersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.exception.UserAlreadyExistsException;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.repositories.UsersRepository;

@Service
public class UsersService {
    private final HashService hashService;
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository, HashService hashService) {
        this.usersRepository = usersRepository;
        this.hashService= hashService;
    }

    public UsersEntity create(UsersEntity user) {
        usersRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new UserAlreadyExistsException(user.getEmail());
                });
        String hashedPassword = hashService.hash(user.getPassword());
        user.setPassword(hashedPassword);
        return this.usersRepository.save(user);
    }
}

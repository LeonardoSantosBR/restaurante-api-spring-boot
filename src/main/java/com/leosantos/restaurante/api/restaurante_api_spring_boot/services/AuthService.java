package com.leosantos.restaurante.api.restaurante_api_spring_boot.services;

import org.springframework.stereotype.Service;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.dto.SigninResponse;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.dto.TokenDto;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.entity.UsersEntity;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.exception.UserNotFoundException;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.exception.WrongPasswordException;
import com.leosantos.restaurante.api.restaurante_api_spring_boot.repositories.UsersRepository;

@Service
public class AuthService {
    private final UsersRepository usersRepository;
    private final HashService hashService;
    private final JwtService jwtService;

    public AuthService(
            UsersRepository usersRepository,
            HashService hashService,
            JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.hashService = hashService;
        this.jwtService = jwtService;
    }

    public SigninResponse signin(String email, String password) {
        UsersEntity user = usersRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());

        if (!hashService.matches(password, user.getPassword())) {
            throw new WrongPasswordException();
        }

        TokenDto tokenDto = new TokenDto(user.getId(), user.getName(), user.getEmail());
        String token = jwtService.generateToken(tokenDto);
        return new SigninResponse(token);
    }
}

package com.leosantos.restaurante.api.restaurante_api_spring_boot.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.dto.TokenDto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtService {

    @Value("${api.security.jwt.secret}")
    private String secret;

    private static final String ISSUER = "auth0-api";

    public String generateToken(TokenDto user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth0-api")
                    .withSubject(String.valueOf(user.id))
                    .withClaim("name", user.name)
                    .withClaim("email", user.email)
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro na geração do token.", exception);
        }
    }

    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();

            return verifier.verify(token);

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token inválido ou expirado.");
        }
    }

     public String getSubject(String token) {
        return validateToken(token).getSubject();
    }

    public String getEmail(String token) {
        return validateToken(token).getClaim("email").asString();
    }

    public String getName(String token) {
        return validateToken(token).getClaim("name").asString();
    }


    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

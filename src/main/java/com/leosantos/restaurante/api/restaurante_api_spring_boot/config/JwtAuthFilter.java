package com.leosantos.restaurante.api.restaurante_api_spring_boot.config;

import java.io.IOException;
import java.util.Collections;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.leosantos.restaurante.api.restaurante_api_spring_boot.services.JwtService;

@Component // anotação genérica de classe gerenciado pelo Spring
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override //haver com polimorfismo, sobrescrever um método da superclasse que extendeu
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {
            // valida assinatura + expiração etc.
            jwtService.validateToken(token);

            // se você coloca userId/email dentro do token, você pode extrair:
            String subject = jwtService.getSubject(token); // ex: email ou userId

            // Aqui você pode carregar roles/perfis do banco se quiser.
            // Por enquanto sem roles:
            var authentication = new UsernamePasswordAuthenticationToken(
                    subject,
                    null,
                    Collections.emptyList());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            // token inválido: não autentica e responde 401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}

package com.movil.boliviaXplore.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final String PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");

/*         if(bearerToken != null && bearerToken.startsWith(PREFIX)) {
            String token = bearerToken.replace(PREFIX, "");
            UsernamePasswordAuthenticationToken upat = TokenUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(upat);
        }*/
        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            String token = bearerToken.replace(PREFIX, "");
            System.out.println("Token recibido: " + token);
            UsernamePasswordAuthenticationToken upat = TokenUtils.getAuthentication(token);
            if (upat != null) {
                System.out.println("Autenticación exitosa");
                SecurityContextHolder.getContext().setAuthentication(upat);
            } else {
                System.out.println("Autenticación fallida");
            }
        }

        filterChain.doFilter(request, response);
    }
    
}
 
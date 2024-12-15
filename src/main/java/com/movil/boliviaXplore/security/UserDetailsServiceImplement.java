package com.movil.boliviaXplore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.repository.UserRepository;

@Service
public class UserDetailsServiceImplement implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User usuario = userRepository.findByCorreoUsuario(email);
        return new UserDetailsImplement(usuario);
    }
}

package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.repository.UserRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Event;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //aun no implementado
    @Override
    public List<Event> getAllFavorites(long codUsuario){
        return null;
    }
    
}

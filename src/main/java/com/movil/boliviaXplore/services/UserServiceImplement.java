package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.repository.UserRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;

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

    public User getUser(Long id){
        return this.userRepository.findById(id).get();
    }
    
}

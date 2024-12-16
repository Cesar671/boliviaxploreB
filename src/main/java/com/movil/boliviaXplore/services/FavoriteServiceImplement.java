package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.repository.FavoriteRepository;
import com.movil.boliviaXplore.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;

@Service
public class FavoriteServiceImplement implements FavoriteService {
    
    private final FavoriteRepository favoriteRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public FavoriteServiceImplement(FavoriteRepository favoriteRepository, EventRepository eventRepository, UserRepository userRepository){
        this.favoriteRepository = favoriteRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Favorite setFavorite(Long codEvent, Long codUser){
        if(this.favoriteRepository.findByCodEvento_CodEventoAndCodUsuario_CodUsuario(codEvent, codUser) == null){
            Event event = eventRepository.findById(codEvent).get();
            User usuario = userRepository.findById(codUser).get();

            Favorite newFavorite = new Favorite();
            newFavorite.setCodEvento(event);
            newFavorite.setCodUsuario(usuario);
            
            return this.favoriteRepository.save(newFavorite);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteFavorite(Long idFavorite){
        Optional <Favorite> favoriteOptional = this.favoriteRepository.findById(idFavorite);
        if (favoriteOptional.isPresent()) {

            this.favoriteRepository.delete(favoriteOptional.get());
        } else {
            System.out.println("no se encontró el registro de favorito");
        }
    }

}

package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.repository.FavoriteRepository;
import com.movil.boliviaXplore.repository.UserRepository;

import jakarta.transaction.Transactional;

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
    public void deleteFavorite(Long codEvent, Long codUser){
        Favorite favorite = this.favoriteRepository.findByCodEvento_CodEventoAndCodUsuario_CodUsuario(codEvent, codUser);
        if (favorite != null) {
            System.out.println("data:"+favorite.getIdFavorite()+" usuario:"+favorite.getCodUsuario().getCodUsuario()+" evento:"+favorite.getCodEvento().getCodEvento());
            this.favoriteRepository.deleteById(favorite.getIdFavorite());
            this.favoriteRepository.flush();
        }
    }

}

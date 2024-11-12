package com.movil.boliviaXplore.services;

import java.util.List;
import com.movil.boliviaXplore.models.Event;

public interface UserService{
    List<Event> getAllFavorites(long codUsuario);
}

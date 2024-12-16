package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Favorite;

public interface FavoriteService{
    Favorite setFavorite(Long codEvent, Long codUser);
    void deleteFavorite(Long idFavorite);
}

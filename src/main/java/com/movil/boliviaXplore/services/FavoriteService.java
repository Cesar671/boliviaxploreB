package com.movil.boliviaXplore.services;
import java.io.IOException;

import com.movil.boliviaXplore.models.Favorite;

public interface FavoriteService{
    Favorite setFavorite(Long codEvent, Long codUser) throws IOException;
    void deleteFavorite(Long codEvent, Long codUser) throws IOException;
}

package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;
import java.util.List;

public interface RecomendationService {
    Event getRecomendation(Long idUser,double longi, double latit);
}

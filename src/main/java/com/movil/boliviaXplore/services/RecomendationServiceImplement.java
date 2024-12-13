package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.repository.UserRepository;
import com.movil.boliviaXplore.services.filter.Filters.FilterByCategory;
import com.movil.boliviaXplore.services.filter.Filters.FilterByDistance;
import com.movil.boliviaXplore.services.filter.Filters.FilterFavorite;
import com.movil.boliviaXplore.services.filter.Filters.FilterNotFavorite;
import com.movil.boliviaXplore.services.filter.distance.HaversineDistance;
import com.movil.boliviaXplore.models.Preferences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.movil.boliviaXplore.services.filter.Filter;
import com.movil.boliviaXplore.models.Event;
import java.util.Map;
import java.util.HashMap;
import com.movil.boliviaXplore.models.Favorite;
import org.springframework.stereotype.Service;
/*
 * 
 * recomendar cuando:
 * establezca favorito
 * distancia
 */
@Service
public class RecomendationServiceImplement implements RecomendationService {
    
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public RecomendationServiceImplement(UserRepository userRepository, EventRepository eventRepository){
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    private List<Event> recomendate(List<Event> eventos, List<Favorite> favorites){
        Map<Long, Integer> prob = new HashMap<>();
        List<Event> recomendedEvents = new LinkedList<>();

        for (Favorite favorite : favorites) {
            Event event = favorite.getCodEvento();
            Category category = event.getIdTipoEvento();
            int data = 0;
            if(!prob.containsKey(category.getIdTipoEvento())){
                data = prob.get(category);
            }
            prob.put(category.getIdTipoEvento(), data+1);
        }

        for (Long key : prob.keySet()) {
            Filter filter = new FilterByCategory(key);
            List<Event> filt = filter.filter(eventos);
            recomendedEvents.addAll(filt);
        }

        return recomendedEvents;
    }

    @Override
    public Event getRecomendation(Long idUser,double longi, double latit){
        User currentUser = userRepository.findById(idUser).get();
        Preferences preferences = currentUser.getPreferences();
        List<Event> events = this.eventRepository.findAll();
        double distance = preferences.getDistance();
        Filter[]filters = { new FilterByDistance(longi, latit, distance, new HaversineDistance()), new FilterNotFavorite(currentUser)};

        for (Filter filter : filters) {
            events = filter.filter(events);
        }

        List<Favorite> favorites = currentUser.getIdFavorite();        
        int min = 0;
        int max = events.size()-1;
        if(events.size() == 0){
            return null;
        }

        if(favorites.size() > 0){
            //no probado aun 
            List<Event> recomendated = this.recomendate(events, favorites);
            max = recomendated.size()-1;
            int index = (int) (Math.random() * (max - min + 1) + min);
            return recomendated.get(index);
        }
        int index = (int) (Math.random() * (max - min + 1) + min);
        return events.get(index);
    } 
}

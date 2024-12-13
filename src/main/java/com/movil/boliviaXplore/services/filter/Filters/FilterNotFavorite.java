package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.services.filter.Filter;
import com.movil.boliviaXplore.models.User;
import java.util.LinkedList;
import java.util.List;

public class FilterNotFavorite implements Filter<Event>{

    private final User user;

    public FilterNotFavorite(User user){
        this.user = user;
    }
    
    @Override
    public List<Event> filter(List<Event> events){
        List<Event> filteredEvents = new LinkedList<>();
        
        for (Event event : events) {
            List<Favorite> favorites = this.user.getIdFavorite();
            boolean exists = false;
            for (Favorite favorite : favorites) {
                long codEventFavorite = favorite.getCodEvento().getCodEvento();
                long codEvent = event.getCodEvento();
                exists = codEventFavorite == codEvent;
            }
            if(!exists){
                filteredEvents.add(event);
            }
        }

        return filteredEvents;
    }
}
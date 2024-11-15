package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.services.filter.Filter;
import com.movil.boliviaXplore.models.User;
import java.util.LinkedList;
import java.util.List;
public class FilterFavorite implements Filter<Event>{

    private final User user;

    public FilterFavorite(User user){
        this.user = user;
    }
    
    @Override
    public List<Event> filter(List<Event> events){
        List<Event> filteredEvents = new LinkedList<>();
        
        for (Event event : events) {
            List<Favorite> favorites = event.getIdFavorite();
            for (Favorite favorite : favorites) {
                int isEquals = favorite.getCodUsuario().getCodUsuario().compareTo(this.user.getCodUsuario());
                if(isEquals == 0){
                    filteredEvents.add(event);
                }
            }
        }

        return filteredEvents;
    }
}

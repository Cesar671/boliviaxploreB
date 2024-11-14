package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.services.filter.Filter;

import java.util.LinkedList;
import java.util.List;
public class FilterFavorite implements Filter<Event>{

    private List<Favorite> favorites;

    public FilterFavorite(List favorites){
        this.favorites = favorites;
    }
    
    @Override
    public List<Event> filter(List events){
        List<Event> filteredEvents = new LinkedList<>();
        
    //mejor llamar al repositorio?
        return filteredEvents;
    }
}

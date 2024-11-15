package com.movil.boliviaXplore.services;

import java.util.LinkedList;
import java.util.List;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;

public class EventFilter implements Filter<Event> {

    private final List<Filter> filters;
    public EventFilter(){
        this.filters = new LinkedList<>();
    }

    public Filter<Event> addFilter(Filter newFilter){
        this.filters.add(newFilter);
        return this;
    }

    @Override
    public List<Event> filter(List events){
        List<Event> eventsFiltered = new LinkedList<>();
        for (Filter filter :this.filters) {
            eventsFiltered = filter.filter(events);
        }
        return eventsFiltered;
    }
}

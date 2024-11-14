package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;

import java.util.LinkedList;
import java.util.List;
public class FilterByCategory implements Filter<Event>{

    private long idCategory;

    public FilterByCategory(long idCategory){
        this.idCategory = idCategory;
    }
    
    @Override
    public List<Event> filter(List events){
        List<Event> filteredEvents = new LinkedList<>();
        for (Object event : events) {
            Event nEvent = (Event) event;
            if(nEvent.getIdTipoEvento().getIdTipoEvento() == this.idCategory){
                filteredEvents.add(nEvent);
            }
        }
        return filteredEvents;
    }
}
package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;

import java.util.LinkedList;
import java.util.List;
public class FilterBySearch implements Filter<Event>{

    private String search;

    public FilterBySearch(String search){
        this.search = search.toLowerCase();
    }
    
    @Override
    public List<Event> filter(List events){
        List<Event> filteredEvents = new LinkedList<>();
        for (Object event : events) {
            Event nEvent = (Event) event;
            String nombre = nEvent.getNombreEvento().toLowerCase();
            String descripcion = nEvent.getDescripcionEvento().toLowerCase();
            String historia = nEvent.getHistoriaEvento().toLowerCase();
            if(
                nombre.contains(this.search) ||
                descripcion.contains(this.search) ||
                historia.contains(this.search)
            ){
                filteredEvents.add(nEvent);
            }
        }
        return filteredEvents;
    }
}

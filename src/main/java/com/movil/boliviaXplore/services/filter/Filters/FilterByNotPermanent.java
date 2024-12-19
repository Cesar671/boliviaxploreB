package com.movil.boliviaXplore.services.filter.Filters;

import java.util.LinkedList;
import java.util.List;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Types;
import com.movil.boliviaXplore.services.filter.Filter;

public class FilterByNotPermanent implements Filter<Event>{
     
    @Override
    public List<Event> filter(List<Event> events) {
        List<Event> filteredEvents = new LinkedList<>();
        for (Event event : events) {
            String type = event.getTipoEvento();
            if(!type.equals(Types.PERMANENTE.toString())){
                filteredEvents.add(event);
            }
        } 
        return filteredEvents;
    }
   
}

package com.movil.boliviaXplore.services.filter.Filters;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Types;
import com.movil.boliviaXplore.services.filter.Filter;

public class FilterByCurrentEvent implements Filter<Event> {

    @Override
    public List filter(List events) {
        List<Event> filteredEvents = new LinkedList<>();
        Date now = new Date();
        for (Object event : events) {
            Event eventCurrent = (Event) event;
            String tipo = eventCurrent.getTipoEvento();
            if(tipo.equals(Types.PERMANENTE.toString())){
                filteredEvents.add(eventCurrent);
            } else {
                Date fechaFin = eventCurrent.getFechaFinEvento();
                if(fechaFin.compareTo(now) >= 0){
                    filteredEvents.add(eventCurrent);
                }
            }
        }
        return filteredEvents;
    }
    
}

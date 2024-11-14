package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
public class FilterActiveEvent implements Filter<Event>{

    @Override
    public List<Event> filter(List events){
        List<Event> filtered = new LinkedList<>();
        Date currentDate = new Date();
        for (Object event : events) {
            Event nEvent = (Event) event;
            Date startEvent = nEvent.getFechaInicioEvento();
            Date endEvent = nEvent.getFechaFinEvento();
            if(currentDate.compareTo(startEvent) >= 0 && currentDate.compareTo(endEvent) <= 0){
                filtered.add(nEvent);
            }
        }

        return filtered;
    }
}

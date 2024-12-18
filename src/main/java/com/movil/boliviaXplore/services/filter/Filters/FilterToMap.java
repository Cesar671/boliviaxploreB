package com.movil.boliviaXplore.services.filter.Filters;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Types;
import com.movil.boliviaXplore.services.filter.Filter;

public class FilterToMap implements Filter<Event>{

    @Override
    public List<Event> filter(List events) {
        List<Event> filtered = new LinkedList<>();
        Date currentDate = new Date();
        for (Object event : events) {
            Event nEvent = (Event) event;
            String tipoEvento = nEvent.getTipoEvento();
            if(tipoEvento.compareTo(Types.PERMANENTE.toString()) == 1){
                filtered.add(nEvent);
            } else {
                Date startEvent = nEvent.getFechaInicioEvento();
                Date endEvent = nEvent.getFechaFinEvento();
                if(currentDate.compareTo(startEvent) >= 0 && currentDate.compareTo(endEvent) <= 0){
                    filtered.add(nEvent);
                }  
            }
        }

        return filtered;
    }
    
}

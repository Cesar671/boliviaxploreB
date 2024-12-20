package com.movil.boliviaXplore.services.filter.Filters;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Types;
import com.movil.boliviaXplore.services.filter.Filter;

public class FilterToMap implements Filter<Event>{

    @Override
    public List<Event> filter(List<Event> events) {
        List<Event> filtered = new LinkedList<>();
        Date currentDate = new Date();
        for (Event nEvent : events) {
            String tipoEvento = nEvent.getTipoEvento();
            if(tipoEvento.equals(Types.PERMANENTE.toString())){
                filtered.add(nEvent);
            } else {
                System.out.println("No entra a la condicion del filtro, error? - "+nEvent.getCodEvento()+" "+nEvent.getIdTipoEvento());
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

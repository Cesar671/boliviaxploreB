package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;

import java.util.LinkedList;
import java.util.List;
public class FilterByCategory implements Filter<Event>{

    private Long idCategory;

    public FilterByCategory(Long idCategory){
        this.idCategory = idCategory;
    }
    
    @Override
    public List<Event> filter(List events){
        List<Event> filteredEvents = new LinkedList<>();
        for (Object event : events) {
            Event nEvent = (Event) event;
            System.out.println(nEvent.getIdTipoEvento().getIdTipoEvento()+" "+ this.idCategory);
            if(nEvent.getIdTipoEvento().getIdTipoEvento() == this.idCategory){
                System.out.println("entra en la comparativa");
                filteredEvents.add(nEvent);
            }
        }
        return filteredEvents;
    }
}

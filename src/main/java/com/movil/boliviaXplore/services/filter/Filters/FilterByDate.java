package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
public class FilterByDate implements Filter<Event>{

    private Date day;
    public FilterByDate(Date date){
        this.day = date;
    }

    @Override
    public List<Event> filter(List events){
        List<Event> filteredEvents = new LinkedList<>();
        Date now = new Date();
        for (Object event : events) {
            Event nEvent = (Event) event;
            if(this.day.compareTo(now) == 0){
                filteredEvents.add(nEvent);
            }
        }
        return filteredEvents;
    }
}
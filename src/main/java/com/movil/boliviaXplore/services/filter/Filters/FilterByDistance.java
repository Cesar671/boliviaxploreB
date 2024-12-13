package com.movil.boliviaXplore.services.filter.Filters;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.filter.Filter;
import com.movil.boliviaXplore.services.filter.distance.Distance;

import java.util.LinkedList;
import java.util.List;
public class FilterByDistance implements Filter<Event>{
    
    private final double longt;
    private final double latit;
    private final Distance distance;
    private final double limit;

    public FilterByDistance(double longt, double latit, double limit, Distance distance){
        this.longt = longt;
        this.latit = latit;
        this.distance = distance;
        this.limit = limit;
    }


    @Override
    public List<Event> filter(List<Event> events){
        List<Event> filteredEvents = new LinkedList<>();
        for (Event event : events) {
            double longEvent = event.getLongitud();
            double latEvent = event.getLatitud();
            double distance = this.distance.calculateDistance(longEvent, latEvent, this.longt, this.latit);
            if (distance <= this.limit) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
}

package com.movil.boliviaXplore.services.filter;
import java.util.List;
import com.movil.boliviaXplore.models.Event;

public interface Filter<T> {
    List<T> filter(List<Event> events);
}

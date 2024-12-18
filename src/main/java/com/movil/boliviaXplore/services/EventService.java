package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Event;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

public interface EventService {
    Event saveEvent(Event event) throws IOException;
    void deleteEvent(long codEvent) throws IOException;
    Event getEvent(Long id);
    List<Event> getAllEvents();
    Map<Integer, List<Event>> getEventDaysInMonth(int year, int month);
    Event updateEvent(Event event);
    void updateImages(List<MultipartFile> files, long idEvent) throws IOException;
    List<Event> getAllEventToMap();
}

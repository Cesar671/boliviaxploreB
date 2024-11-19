package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Event;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface EventService {
    Event saveEvent(Event event, List<MultipartFile> file) throws IOException;
    void deleteEvent(Event event) throws IOException;
    Event getEvent(Long id);
    List<Event> getAllEvents();
}

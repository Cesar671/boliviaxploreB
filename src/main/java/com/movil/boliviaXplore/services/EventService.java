package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Event;

import java.io.IOException;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface EventService {
    Event saveEvent(Event event, MultipartFile file) throws IOException;
    void deleteEvent(Event event) throws IOException;
    Optional<Event> getEvent(Long id);
}

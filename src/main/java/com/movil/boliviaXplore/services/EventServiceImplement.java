package com.movil.boliviaXplore.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.repository.EventRepository;

@Service
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    private final ImageService imageService;
    public EventServiceImplement(EventRepository eventRepository, ImageService imageService){
        this.eventRepository = eventRepository;
        this.imageService = imageService;
    }

    @Override
    public Event saveEvent(Event event, MultipartFile multipartFile) throws IOException{
        Event addedEvent = null;
        if(multipartFile != null && !multipartFile.isEmpty()){
            addedEvent = this.eventRepository.save(event);
            this.imageService.uploadImage(multipartFile, addedEvent);
        }
        return addedEvent;
    }

    @Override
    public void deleteEvent(Event event)throws IOException{}

}

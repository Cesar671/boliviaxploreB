package com.movil.boliviaXplore.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;
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
    public Event saveEvent(Event event, MultipartFile multipartFile){
        Event addedEvent = null;
        try{
        if(multipartFile != null && !multipartFile.isEmpty()){
            System.out.println(event.getIdTipoEvento());
            addedEvent = this.eventRepository.save(event);
            this.imageService.uploadImage(multipartFile, addedEvent);
        }} catch (Exception e){ System.out.println(e.getMessage()); }
        return addedEvent;
    }

    @Override
    public Optional<Event> getEvent(Long id){
        return this.eventRepository.findById(id);
    }

    @Override
    public void deleteEvent(Event event)throws IOException{}

}

package com.movil.boliviaXplore.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.repository.EventRepository;
import java.util.List;

@Service
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    private final ImageService imageService;
    public EventServiceImplement(EventRepository eventRepository, ImageService imageService){
        this.eventRepository = eventRepository;
        this.imageService = imageService;
    }

    @Override
    public Event saveEvent(Event event, List<MultipartFile> multipartFiles){
        Event addedEvent = null;
        try{
            System.out.println("pasa por 1");
            addedEvent = this.eventRepository.save(event);
            System.out.println("pasa por 2"+addedEvent.getCodEvento());
            for (MultipartFile multipartFile : multipartFiles) {
                System.out.println("pasa por 3");
                this.imageService.uploadImage(multipartFile, addedEvent);
            }
        } catch (Exception e){ System.out.println(e.getMessage()); }
        return addedEvent;
    }

    @Override
    public Optional<Event> getEvent(Long id){
        return this.eventRepository.findById(id);
    }

    @Override
    public void deleteEvent(Event event)throws IOException{}

}

package com.movil.boliviaXplore.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.repository.EventRepository;
import java.util.List;
import com.movil.boliviaXplore.models.Image;
import com.movil.boliviaXplore.DTO.EventDTO;

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
            addedEvent = this.eventRepository.save(event);
            for (MultipartFile multipartFile : multipartFiles) {
                this.imageService.uploadImage(multipartFile, addedEvent);
            }
        } catch (Exception e){ System.out.println(e.getMessage()); }
        return addedEvent;
    }

    @Override
    public Event getEvent(Long id){
        return this.eventRepository.findById(id).get();
    }

    @Override
    public List<Event> getAllEvents(){
        return this.eventRepository.findAll();
    }

    @Override
    public void deleteEvent(Event event){
        List<Image> images = event.getImagenes();
        try{
            for (Image image : images) {
                this.imageService.deleteImage(image);
            }
            eventRepository.delete(event);
        } catch(Exception e){
            System.out.println(e.getMessage()+" error de la imagen");
        } 
    }

}

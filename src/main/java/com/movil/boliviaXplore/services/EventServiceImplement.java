package com.movil.boliviaXplore.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.repository.EventRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.movil.boliviaXplore.models.Image;
import java.util.Date;
import java.util.Set;
import java.util.Collections;

@Service
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    private final ImageService imageService;
    public EventServiceImplement(EventRepository eventRepository, ImageService imageService){
        this.eventRepository = eventRepository;
        this.imageService = imageService;
    }

    //faltan las imagenes
    @Override
    public Event updateEvent(Event eventNewData, List<MultipartFile> files) {  
        Long idEvent = eventNewData.getCodEvento();
        Event eventMatched = this.eventRepository.findById(idEvent).map( e -> {
            e.setNombreEvento(eventNewData.getNombreEvento());
            e.setDescripcionEvento(eventNewData.getDescripcionEvento());
            e.setLatitud(eventNewData.getLatitud());
            e.setLongitud(eventNewData.getLongitud());
            e.setHistoriaEvento(eventNewData.getHistoriaEvento());
            e.setFechaInicioEvento(eventNewData.getFechaInicioEvento());
            e.setFechaFinEvento(eventNewData.getFechaFinEvento());
            e.setPermanente(eventNewData.getPermenente());
            e.setCategory(eventNewData.getIdTipoEvento());
            e.setUbicacion(eventNewData.getUbicacion());
            return eventRepository.save(e);
        }).get();
        return eventMatched;
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

    @Override
    public List<Integer> getEventDaysInMonth(int year, int month){
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        // Convertir LocalDate a java.util.Date
        Date start = java.sql.Date.valueOf(startDate);
        Date end = java.sql.Date.valueOf(endDate);

        // Consultar eventos
        List<Event> events = eventRepository.findEventsInMonth(start, end);

        // Extraer los días únicos
        Set<Integer> days = new HashSet<>();
        for (Event event : events) {
            LocalDate startEvent = event.getFechaInicioEvento()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDate endEvent = event.getFechaFinEvento()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Recorrer todos los días entre el rango de inicio y fin del evento
            while (!startEvent.isAfter(endEvent)) {
                if (!startEvent.isBefore(startDate) && !startEvent.isAfter(endDate)) {
                    days.add(startEvent.getDayOfMonth());
                }
                startEvent = startEvent.plusDays(1);
            }
        }

        // Ordenar los días
        List<Integer> sortedDays = new ArrayList<>(days);
        Collections.sort(sortedDays);
        return sortedDays;
    }

}

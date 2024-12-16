package com.movil.boliviaXplore.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.repository.FavoriteRepository;
import com.movil.boliviaXplore.repository.ImageRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import com.movil.boliviaXplore.models.Image;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;
    private final ImageService imageService;
    private final FavoriteRepository favoriteRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    public EventServiceImplement(
                    EventRepository eventRepository, 
                    ImageService imageService, 
                    FavoriteRepository favoriteRepository,
                    CategoryRepository categoryRepository,
                    ImageRepository imageRepository){
        this.eventRepository = eventRepository;
        this.imageService = imageService;
        this.favoriteRepository = favoriteRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
    }

    //faltan las imagenes
    @Override
    public Event updateEvent(Event eventNewData) {  
        Category category = this.categoryRepository.findById(eventNewData.getIdTipoEvento().getIdTipoEvento()).get();
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
            e.setCategory(category);
            e.setUbicacion(eventNewData.getUbicacion());
            return eventRepository.save(e);
        }).get();
        return eventMatched;
    }

    @Override 
    public void updateImages(List<MultipartFile> files, long idEvent) throws IOException{
        Optional<Event> eventOptional = this.eventRepository.findById(idEvent);
        if(eventOptional.isPresent()){
            Event event = eventOptional.get();
            List<Image> images = event.getImagenes();
            this.deleteAllImages(images);
            this.saveImages(files, idEvent);
        } else {
            throw new IOException();
        }
    }

    private void deleteAllImages(List<Image> images){
        try{
            for (Image image : images) {
                Optional<Image> optionalImage = this.imageRepository.findById(image.getCodImagen());
                if (optionalImage.isPresent()) {
                    imageService.deleteImage(optionalImage.get());
                } else {
                    System.out.println("Imagen no encontrada con ID: " + image.getCodImagen());
                }
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Event saveEvent(Event event){
        Event addedEvent = this.eventRepository.save(event);
        return addedEvent;
    }

    public void saveImages(List<MultipartFile> files,Long eventId){
        Event event = this.eventRepository.findById(eventId).get();
        try{
            for (MultipartFile multipartFile : files) {
                this.imageService.uploadImage(multipartFile, event);
            }
        } catch (Exception e){ System.out.println(e.getMessage()); }
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
    public void deleteEvent(long codEvent){
        Optional<Event> eventOptional = this.eventRepository.findById(codEvent);
        if(eventOptional.isPresent()){
            Event event = eventOptional.get();
            List<Image> images = event.getImagenes();
            List<Favorite> favorites = event.getIdFavorite();
            try{
                this.deleteAllImages(images);
                this.deleteAllFavorites(favorites);
                eventRepository.delete(event);
            } catch(Exception e){
                System.out.println(e.getMessage()+" error de la imagen");
            } 
        } else {
            System.out.println(" el evento no existe");
        }
       
    }
    @Transactional
    private void deleteAllFavorites(List<Favorite> favorites){
        for (Favorite favorite : favorites) {
            Favorite fav = this.favoriteRepository.findById(favorite.getIdFavorite()).get();
            this.favoriteRepository.delete(fav);
        }
    }

    @Override
    public Map<Integer, List<Event>> getEventDaysInMonth(int year, int month){
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        // Convertir LocalDate a java.util.Date
        Date start = java.sql.Date.valueOf(startDate);
        Date end = java.sql.Date.valueOf(endDate);

        // Consultar eventos
        List<Event> events = eventRepository.findEventsInMonth(start, end);

        // Extraer los días únicos
        Set<Integer> days = new HashSet<>();
        Map<Integer, List<Event>> eventosPorDia = new HashMap<>();

        for (Event event : events) {
            // Convertir las fechas de inicio y fin del evento a LocalDate
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
                // Solo agregar días dentro del rango especificado (startDate, endDate)
                if (!startEvent.isBefore(startDate) && !startEvent.isAfter(endDate)) {
                    int dia = startEvent.getDayOfMonth(); // Obtener el día como número entero

                    // Agregar el día al conjunto de días
                    days.add(dia);

                    // Si no existe la lista de eventos para este día, inicializarla
                    eventosPorDia.computeIfAbsent(dia, k -> new LinkedList<>());

                    // Agregar el evento a la lista del día correspondiente
                    eventosPorDia.get(dia).add(event);
                }

                // Avanzar al siguiente día
                startEvent = startEvent.plusDays(1);
            }
        }
        // Retornar la lista de días ordenados
        return eventosPorDia;
    }

}

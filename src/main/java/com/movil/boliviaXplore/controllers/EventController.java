package com.movil.boliviaXplore.controllers;

import com.movil.boliviaXplore.DTO.EventDTO;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.EventFilter;
import com.movil.boliviaXplore.services.EventServiceImplement;
import com.movil.boliviaXplore.services.FavoriteServiceImplement;
import com.movil.boliviaXplore.services.UserServiceImplement;
import com.movil.boliviaXplore.services.filter.Filters.FilterByCategory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import com.movil.boliviaXplore.models.Favorite;
import java.util.Map;
import java.util.List;
import java.util.Date;



@RestController
@RequestMapping("/api/event")
public class EventController {
    
    @Autowired
    EventServiceImplement eventServiceImplement;

    @Autowired
    FavoriteServiceImplement favoriteServiceImplement;

    @Autowired
    UserServiceImplement userServiceImplement;

    @PostMapping("/register")
    public ResponseEntity<Event> createEvent(@RequestPart("event") Event event, @RequestPart("imagenes") List<MultipartFile> multipartFile) {
        try{
            Event savedEvent = eventServiceImplement.saveEvent(event, multipartFile);
            return new ResponseEntity<>(savedEvent, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") Long codEvento){
        Event event = eventServiceImplement.getEvent(codEvento);
        eventServiceImplement.deleteEvent(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable("id") Long eventId) {
        try{
            Event event = eventServiceImplement.getEvent(eventId);
            return new ResponseEntity<>(EventDTO.getInstance(event), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/mark-favorite")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Map<String, Object> payload) {
        Long codEvento = ((Number) payload.get("codEvento")).longValue();
        Long codUsuario = ((Number) payload.get("codUsuario")).longValue();
        System.out.println("pasa por 1"+codEvento+" "+codUsuario);
        Favorite favorite = this.favoriteServiceImplement.setFavorite(codEvento, codUsuario);
        System.out.println("pasa por 1");
        return new ResponseEntity<>(favorite, HttpStatus.OK);
    }

    @DeleteMapping("/mark-favorite")
    public ResponseEntity<Favorite> deleteFavorite(@RequestBody Map<String, Object> payload){
        Long codUsuario = ((Number) payload.get("codUsuario")).longValue();
        Long codEvento = ((Number) payload.get("codEvento")).longValue();
        this.favoriteServiceImplement.deleteFavorite(codEvento, codUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/filtered")
    public ResponseEntity<List<Event>> getFilteredEvents(@RequestBody Map<String, Object> payload){
        boolean eventoActivo = (boolean) payload.get("eventoActivo");
        Date fecha = (Date) payload.get("fecha");
        String distancia = (String) payload.get("distancia");
        String busqueda = (String) payload.get("busqueda");
        Long idCategoria = ((Number) payload.get("categoria")).longValue();
        boolean favorito = (boolean) payload.get("favorito");
        Long codUsuario = ((Number) payload.get("codUsuario")).longValue();

        List<Event> eventos = eventServiceImplement.getAllEvents();

        EventFilter eventFilter = new EventFilter();
        if(idCategoria != null){
            eventFilter.addFilter(new FilterByCategory(idCategoria));
        }
        
        List<Event> eventFiltered = eventFilter.filter(eventos);

        return new ResponseEntity<>(eventFiltered, HttpStatus.OK);
    }
    
}

package com.movil.boliviaXplore.controllers;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.EventServiceImplement;
import com.movil.boliviaXplore.services.FavoriteServiceImplement;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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



@RestController
@RequestMapping("/api/event")
@CrossOrigin("http://localhost:8080/")
public class EventController {
    
    @Autowired
    EventServiceImplement eventServiceImplement;

    @Autowired
    FavoriteServiceImplement favoriteServiceImplement;

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
        Event event = eventServiceImplement.getEvent(codEvento).get();
        eventServiceImplement.deleteEvent(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEvent(@PathVariable("id") Long eventId) {
        try{
            Optional<Event> event = eventServiceImplement.getEvent(eventId);
            return new ResponseEntity<>(event, HttpStatus.OK);
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
    
    /*
    @GetMapping("/filtered")
    public ResponseEntity<Event> getFilteredEvents(@PathVariable("favorito") boolean favorito, 
                                                    @PathVariable("eventoActivo") boolean eventoActivo,
                                                    @PathVariable("fecha") Date fecha,
                                                    @PathVariable("distancia") String distancia,
                                                    @PathVariable("busqueda") String busqueda,
                                                    @PathVariable("categoria") long categoria){
        try{
            Event savedEvent = eventServiceImplement.saveEvent(event, multipartFile);
            return new ResponseEntity<>(savedEvent, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/
    
}

package com.movil.boliviaXplore.controllers;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.EventServiceImplement;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;



@RestController
@RequestMapping("/api/event")
@CrossOrigin("http://localhost:8080/")
public class EventController {
    
    @Autowired
    EventServiceImplement eventServiceImplement;


    @PostMapping("/register")
    public ResponseEntity<Event> postMethodName(@RequestPart("event") Event event, @RequestPart("imagen") MultipartFile multipartFile) {
        System.out.println(event);
        try{
            Event savedEvent = eventServiceImplement.saveEvent(event, multipartFile);
            return new ResponseEntity<>(savedEvent, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

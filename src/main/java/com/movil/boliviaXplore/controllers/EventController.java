package com.movil.boliviaXplore.controllers;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.EventServiceImplement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/event")
@CrossOrigin("http://localhost:8080/")
public class EventController {
    
    @Autowired
    EventServiceImplement eventServiceImplement;


    @PostMapping("/register")
    public ResponseEntity<Event> postMethodName(@RequestPart("event") Event event, @RequestPart("imagen") MultipartFile multipartFile) {
        try{
            Event savedEvent = eventServiceImplement.saveEvent(event, multipartFile);
            return new ResponseEntity<>(savedEvent, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
}

package com.movil.boliviaXplore.controllers;

import com.movil.boliviaXplore.DTO.EventDTO;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.services.EventFilter;
import com.movil.boliviaXplore.services.EventServiceImplement;
import com.movil.boliviaXplore.services.FavoriteServiceImplement;
import com.movil.boliviaXplore.services.UserServiceImplement;
import com.movil.boliviaXplore.services.filter.Filters.FilterActiveEvent;
import com.movil.boliviaXplore.services.filter.Filters.FilterByCategory;
import com.movil.boliviaXplore.services.filter.Filters.FilterByDate;
import com.movil.boliviaXplore.services.filter.Filters.FilterBySearch;
import com.movil.boliviaXplore.services.filter.Filters.FilterFavorite;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.models.User;

import java.util.Map;
import java.util.List;
import java.text.SimpleDateFormat;
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
        try{
            Event event = eventServiceImplement.getEvent(codEvento);
            eventServiceImplement.deleteEvent(event);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    //DTO added
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
        try{
            Long codEvento = ((Number) payload.get("codEvento")).longValue();
            Long codUsuario = ((Number) payload.get("codUsuario")).longValue();
            Favorite favorite = this.favoriteServiceImplement.setFavorite(codEvento, codUsuario);
            return new ResponseEntity<>(favorite, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/mark-favorite")
    public ResponseEntity<Favorite> deleteFavorite(@RequestBody Map<String, Object> payload){
        try{
            Long codUsuario = ((Number) payload.get("codUsuario")).longValue();
            Long codEvento = ((Number) payload.get("codEvento")).longValue();
            this.favoriteServiceImplement.deleteFavorite(codEvento, codUsuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @PostMapping("/filtered")
    public ResponseEntity<List<Event>> getFilteredEvents(@RequestBody Map<String, Object> payload){
        List<Event> eventos = eventServiceImplement.getAllEvents();
        try{ 
            boolean eventoActivo = (boolean) payload.get("eventoActivo");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Object dateobj = payload.get("fecha");
            String date = dateobj != null ? dateobj.toString():null;
            Date fecha = null;
            if (date != null) {
                fecha = formatter.parse(date);
            }
            String distancia = (String) payload.get("distancia");
            String busqueda = (String) payload.get("busqueda");
            Long idCategoria =(payload.get("categoria") != null) ? ((Number) payload.get("categoria")).longValue():null;
            boolean favorito = (boolean) payload.get("favorito");
            Long codUsuario = (payload.get("codUsuario") != null) ? ((Number) payload.get("codUsuario")).longValue():null;
            EventFilter eventFilter = new EventFilter();
            if(idCategoria != null){
                eventFilter.addFilter(new FilterByCategory(idCategoria));
            }
            if(fecha != null){
                eventFilter.addFilter(new FilterByDate(fecha));
            }
            if(busqueda.length() > 0){
                eventFilter.addFilter(new FilterBySearch(busqueda));
            }

            if(eventoActivo){
                eventFilter.addFilter(new FilterActiveEvent());
            }

            if(favorito){
                User user = this.userServiceImplement.getUser(codUsuario);
                eventFilter.addFilter(new FilterFavorite(user));
            }

            if(eventFilter.existsFilters()){
                return new ResponseEntity<>(eventFilter.filter(eventos), HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }
    
}

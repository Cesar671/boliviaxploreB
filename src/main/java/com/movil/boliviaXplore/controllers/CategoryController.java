package com.movil.boliviaXplore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movil.boliviaXplore.DTO.CategoryDTO;
import com.movil.boliviaXplore.services.CategoryServiceImplement;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.movil.boliviaXplore.DTO.EventDTO;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryServiceImplement categoryServiceImplement;

    @GetMapping("/{id}")
    public ResponseEntity<List<EventDTO>> getEventsByCategory(@PathVariable("id") Long id) {
        try{
            List<EventDTO> events = categoryServiceImplement.getEventsByCategory(id);
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<EventDTO>> getEventsByNameCategory(@PathVariable("name") String name) {
        try{
            List<EventDTO> events = categoryServiceImplement.getEventsByCategory(name);
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = this.categoryServiceImplement.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    
}

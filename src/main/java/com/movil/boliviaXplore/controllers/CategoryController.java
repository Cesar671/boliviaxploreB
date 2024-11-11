package com.movil.boliviaXplore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movil.boliviaXplore.services.CategoryServiceImplement;
import com.movil.boliviaXplore.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryServiceImplement categoryServiceImplement;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryWithEvents(@PathVariable("id") Long id) {
        Optional<Category> category = categoryServiceImplement.getEventsByCategory(id);
        if(category.isPresent()){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}

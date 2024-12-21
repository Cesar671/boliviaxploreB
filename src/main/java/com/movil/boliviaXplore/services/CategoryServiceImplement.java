package com.movil.boliviaXplore.services;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.DTO.CategoryDTO;
import com.movil.boliviaXplore.DTO.EventDTO;
import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.services.filter.Filter;
import com.movil.boliviaXplore.services.filter.Filters.FilterByCurrentEvent;

import java.util.Optional;
import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryServiceImplement implements CategoryService{
    private final CategoryRepository categoryRepository;


    public CategoryServiceImplement(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

   

    @Override
    public List<EventDTO> getEventsByCategory(long id){
        Category category = this.categoryRepository.findById(id).get();
        List<Event> events = category.getEvents();
        Filter filterCurrent = new FilterByCurrentEvent();
        List<Event> eventFiltered = filterCurrent.filter(events);
        List<EventDTO> eventsDTO = new LinkedList<>();
        for (Event event : eventFiltered) {
            eventsDTO.add(EventDTO.getInstance(event));
        }
        return eventsDTO; 
    }

    @Override
    public List<EventDTO> getEventsByCategory(String name){
        Category category = this.categoryRepository.findByNombreCategoria(name);
        List<Event> events = category.getEvents();
        Filter filterCurrent = new FilterByCurrentEvent();
        List<Event> eventFiltered = filterCurrent.filter(events);
        List<EventDTO> eventsDTO = new LinkedList<>();
        for (Event event : eventFiltered) {
            eventsDTO.add(EventDTO.getInstance(event));
        }
        return eventsDTO; 
    }

    @Override
    public List<CategoryDTO> getAllCategories(){
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDTO> categoriesDto = new LinkedList<>();
        for (Category category : categories) {
            categoriesDto.add(CategoryDTO.getInstance(category));
        }
        return categoriesDto;
    }
}

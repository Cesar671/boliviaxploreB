package com.movil.boliviaXplore.services;


import java.util.List;
import com.movil.boliviaXplore.DTO.CategoryDTO;

import com.movil.boliviaXplore.DTO.CategoryDTO;
import com.movil.boliviaXplore.DTO.EventDTO;

public interface CategoryService {
    List<EventDTO> getEventsByCategory(long id);
    List<CategoryDTO> getAllCategories();
}

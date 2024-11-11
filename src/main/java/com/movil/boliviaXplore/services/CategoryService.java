package com.movil.boliviaXplore.services;


import com.movil.boliviaXplore.models.Category;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> getEventsByCategory(long id);
}

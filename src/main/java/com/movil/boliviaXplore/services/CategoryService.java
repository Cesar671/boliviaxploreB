package com.movil.boliviaXplore.services;


import com.movil.boliviaXplore.models.Category;
import java.util.Optional;
import java.util.List;

public interface CategoryService {
    Optional<Category> getEventsByCategory(long id);
    List<Category> getAllCategories();
}

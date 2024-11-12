package com.movil.boliviaXplore.services;

import org.springframework.stereotype.Service;

import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.repository.CategoryRepository;
import java.util.Optional;
import java.util.List;

@Service
public class CategoryServiceImplement implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplement(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> getEventsByCategory(long id){
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }
}

package com.movil.boliviaXplore.loaders;

import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Category;
import java.io.IOException;

@Component
public class DataEventLoader implements ApplicationRunner {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    public DataEventLoader(EventRepository eventRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {
        if (eventRepository.count() == 0) {
            List<Category> categories = categoryRepository.findAll(); 

            for (int i = 0; i < 10; i++) {
                Event event = new Event();
                event.setNombreEvento("asdasdqweqwasdqweqw");  
                event.setDescripcionEvento("asdqweadasdqweqw");  
                event.setUbicacion("asdqweqwasdqewqe");  
                event.setHistoriaEvento("asdqweqweasdqweqweqwa");  
                event.setIcon("asdqweqwasdqweqweqweqasdqwe");  
                event.setFechaInicioEvento(new Date());
                event.setFechaFinEvento(new Date());

                Category randomCategory = categories.get(new Random().nextInt(categories.size()-1));  
                event.setCategory(randomCategory);

                this.eventRepository.save(event);  
            }
        }
    }
}

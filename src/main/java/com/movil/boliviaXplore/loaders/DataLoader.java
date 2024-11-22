package com.movil.boliviaXplore.loaders;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.models.Event;

@Component("datacategoryloader")
public class DataLoader implements ApplicationRunner{
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;

    public DataLoader(EventRepository eventRepository,CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException{
        if( categoryRepository.count() == 0 ){
            Category category1 = new Category();
            category1.setNombreCategoria("Celebraciones Folcloricas");
            Category category2 = new Category();
            category2.setNombreCategoria("Festivales Tradicionales");
            Category category3 = new Category();
            category3.setNombreCategoria("Lugares Turisticos");
            Category category4 = new Category();
            category4.setNombreCategoria("Conciertos Conteporaneos");
            Category category5 = new Category();
            category5.setNombreCategoria("Exposiciones de Arte");
            Category category6 = new Category();
            category6.setNombreCategoria("Ferias Artesanales");
            
            this.categoryRepository.save(category1);
            this.categoryRepository.save(category2);
            this.categoryRepository.save(category3);
            this.categoryRepository.save(category4);
            this.categoryRepository.save(category5);
            this.categoryRepository.save(category6);

            List<Category> categories = categoryRepository.findAll(); 

            for (int i = 0; i < 10; i++) {
                Event event = new Event();
                event.setNombreEvento("asdasdqweqwasdqweqw");  
                event.setDescripcionEvento("asdqweadasdqweqw");  
                event.setLongitud(((Number) 1234).longValue());
                event.setLatitud(((Number) 12345).longValue());  
                event.setHistoriaEvento("asdqweqweasdqweqweqwa");  
                LocalDate a = LocalDate.of(2024, 11, 02);
                LocalDate b = LocalDate.of(2024, 11, 04);
                try{
                    event.setFechaInicioEvento(Date.from(a.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    event.setFechaFinEvento(Date.from(b.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                } catch (Exception e){}
                
                

                Category randomCategory = categories.get(3);  
                event.setCategory(randomCategory);

                this.eventRepository.save(event);  
            }
        }
    }
}

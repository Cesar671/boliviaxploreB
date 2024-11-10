package com.movil.boliviaXplore.loaders;

import java.io.IOException;
 
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.models.Category;
@Component
public class DataLoader implements ApplicationRunner{
    private final CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
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
        }
    }
}

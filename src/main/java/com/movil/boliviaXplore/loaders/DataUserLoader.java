package com.movil.boliviaXplore.loaders;

import java.io.IOException;
import com.movil.boliviaXplore.models.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.movil.boliviaXplore.repository.UserRepository;

@Component
public class DataUserLoader implements ApplicationRunner{
    private final UserRepository userRepository;

    public DataUserLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException{
        if( userRepository.count() == 0 ){
            User user = new User();
            userRepository.save(user);
        }
    }
}

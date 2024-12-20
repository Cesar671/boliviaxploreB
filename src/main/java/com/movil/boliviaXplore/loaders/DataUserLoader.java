package com.movil.boliviaXplore.loaders;

import java.io.IOException;

import com.movil.boliviaXplore.models.Preferences;
import com.movil.boliviaXplore.models.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.movil.boliviaXplore.repository.PreferencesRepository;
import com.movil.boliviaXplore.repository.UserRepository;


@Component("datauserloader")
public class DataUserLoader implements ApplicationRunner{
    private final UserRepository userRepository;
    private final PreferencesRepository preferencesRepository;
    public DataUserLoader(UserRepository userRepository, PreferencesRepository preferencesRepository){
        this.userRepository = userRepository;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException{
        if( userRepository.count() == 0 ){
            
        }
    }
}

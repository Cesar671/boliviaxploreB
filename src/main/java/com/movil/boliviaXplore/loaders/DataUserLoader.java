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
            User user = new User();
            user.setCorreoUsuario("admin1234@gmail.com");
            user.setNombreUsuario("admin");
            user.setRolUsuario(1);
            user.setPassword("admin1234@gmail.com");
            user.setFotoUsuario("https://vidaenusa.org/wp-content/uploads/2023/12/cuanto-gana-administrador-empresas-usa.jpg");
            User userN = this.userRepository.save(user);
            Preferences pref = this.preferencesRepository.save(new Preferences(userN)); 
            userN.setPreferences(pref);
            userRepository.save(user);
        }
    }
}

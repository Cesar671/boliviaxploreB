package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.repository.PreferencesRepository;
import com.movil.boliviaXplore.repository.UserRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Preferences;
import com.movil.boliviaXplore.models.User;
import java.util.Optional;
@Service
public class UserServiceImplement implements UserService{

    private static final String CLIENT_ID = "";
    private final UserRepository userRepository;
    private final PreferencesRepository preferencesRepository;
    public UserServiceImplement(UserRepository userRepository, PreferencesRepository preferencesRepository){
        this.userRepository = userRepository;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public GoogleIdToken.Payload verifyGoogleIdToken(String idToken){
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
        .setAudience(Collections.singletonList(CLIENT_ID))
        .build();
        try{
            GoogleIdToken idTokenGoogle = verifier.verify(idToken);
            if(idTokenGoogle == null){
                return null;
            }
            else return idTokenGoogle.getPayload();
        } catch (Exception e) {
            System.out.println("excepcion de tokenId "+e.getMessage());
            return null;
        }
        
    }

    //aun no implementado
    @Override
    public List<Event> getAllFavorites(long codUsuario){
        return null;
    }

    @Override
    public User getUser(Long id){
        return this.userRepository.findById(id).get();
    }

    @Override
    public User createUser(String name, String email, String urlFoto, String password){
        User user = this.userRepository.findByCorreoUsuario(email);
        if(user == null){
            user = new User();
            user.setNombreUsuario(name);
            user.setCorreoUsuario(email);
            user.setPassword(password);
            user.setFotoUsuario(urlFoto);
            user.setGoogleId(null);
            user.setAuthProvider(null);
            User userN = this.userRepository.save(user);
            Preferences pref = this.preferencesRepository.save(new Preferences(userN)); 
            userN.setPreferences(pref);
            return this.userRepository.save(userN);
        }
        return user;
    }

    @Override
    public void updatePreferences(Preferences preferences){
        this.preferencesRepository.findById(preferences.getIdPreferences()).map( p -> {
            p.setDistance(preferences.getDistance());
            p.setFavoriteNearNotification(preferences.getFavoriteNearNotification());
            p.setLanguaje(preferences.getLanguage());
            p.setNearEventNotification(preferences.getNearNotification());
            p.setRecomendations(preferences.getRecomendations());
            p.setNotificationRecomendation(preferences.getNotificationsRecomendation());
            return this.preferencesRepository.save(p);
        });
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = this.userRepository.findByCorreoUsuarioAndPassword(email, password);
        return user;
    }
    
}

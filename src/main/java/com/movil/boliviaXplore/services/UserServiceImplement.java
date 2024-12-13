package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.repository.UserRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;

@Service
public class UserServiceImplement implements UserService{

    private static final String CLIENT_ID = "";
    private final UserRepository userRepository;
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository = userRepository;
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

    public User getUser(Long id){
        return this.userRepository.findById(id).get();
    }
    
}

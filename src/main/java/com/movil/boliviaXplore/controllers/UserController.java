package com.movil.boliviaXplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

import com.cloudinary.http5.api.Response;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.services.UserServiceImplement;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.movil.boliviaXplore.models.Preferences;


@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImplement userServiceImplement;

    @PostMapping("/create")
    public ResponseEntity<User> login(@RequestBody Map<String, Object> entity) {
        String name =  entity.get("name").toString();
        String email = entity.get("email").toString();
        String urlFoto = entity.get("urlFoto").toString();
        String googleId = entity.get("googleID").toString();
        String authProvider = entity.get("authProvider").toString();

        User user = this.userServiceImplement.createUser(name, email, urlFoto, googleId, authProvider);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updatepreferences")
    public ResponseEntity updatePreferences(@RequestBody Map<String, Object> payload) {
        double distance = (double) payload.get("distance");
        //time
        boolean favoriteNearNotification = (boolean) payload.get("favoriteNearNotification");
        String language = payload.get("language").toString();
        //place
        boolean NearEventNotification = (boolean) payload.get("nearEventNotification");
        boolean recomendations = (boolean) payload.get("recomendations");
        boolean recomendationNotification = (boolean) payload.get("notificationRecomendation");
        long idPreferences = ((Number) payload.get("idPreferences")).longValue(); 

        Preferences preferences = new Preferences();
        preferences.setIdPreferences(idPreferences);
        preferences.setDistance(distance);
        preferences.setFavoriteNearNotification(favoriteNearNotification);
        preferences.setLanguaje(language);
        preferences.setNearEventNotification(NearEventNotification);
        preferences.setRecomendations(recomendations);
        preferences.setNotificationRecomendation(recomendationNotification);
        this.userServiceImplement.updatePreferences(preferences);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

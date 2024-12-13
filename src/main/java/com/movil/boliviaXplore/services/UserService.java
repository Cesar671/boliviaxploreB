package com.movil.boliviaXplore.services;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.movil.boliviaXplore.models.Event;

public interface UserService{
    List<Event> getAllFavorites(long codUsuario);
    GoogleIdToken.Payload verifyGoogleIdToken(String idToken);
}

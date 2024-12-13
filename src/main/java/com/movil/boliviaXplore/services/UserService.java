package com.movil.boliviaXplore.services;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.models.Preferences;

public interface UserService{
    List<Event> getAllFavorites(long codUsuario);
    GoogleIdToken.Payload verifyGoogleIdToken(String idToken);
    User getUser(Long idUser);
    User createUser(
        String name,
        String email,
        String urlFoto,
        String goodleId,
        String authProvider
    );
    void updatePreferences(Preferences preferences);
}

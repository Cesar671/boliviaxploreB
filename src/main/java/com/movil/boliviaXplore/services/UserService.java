package com.movil.boliviaXplore.services;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.User;
import com.movil.boliviaXplore.models.Preferences;
import java.util.Optional;
public interface UserService{
    List<Event> getAllFavorites(long codUsuario);
    GoogleIdToken.Payload verifyGoogleIdToken(String idToken);
    User getUser(Long idUser);
    User createUser(
        String name,
        String email,
        String urlFoto,
        String password
    );
    void updatePreferences(Preferences preferences);
    Optional<User> getUserByEmailAndPassword(String email, String password);
}

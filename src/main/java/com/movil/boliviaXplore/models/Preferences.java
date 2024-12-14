package com.movil.boliviaXplore.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.persistence.Column;


@Entity
@Table(name = "preferencias")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPreferences")
    private Long idPreferences;

    @Column(name = "idioma")
    private String language = "es";

    @Column(name = "distancia")
    private double distance = 200;

    @Column(name = "recomendations")
    private boolean recomendations = true;

    @Column(name = "notificationRecomendation")
    private boolean notificationRecomendations = true;

    @Column(name = "nearEventNotification")
    private boolean nearEventNotification = true;

    @Column(name = "favoriteNearNotification")
    private boolean favoriteNearNotification = true;

    @OneToOne(mappedBy = "preferences") // Relación inversa con User
    private User user;

    public Preferences(){}

    public Preferences(User user){
        this.user = user;
    }

    public void setIdPreferences(Long idPreferences){
        this.idPreferences = idPreferences;
    }

    public Long getIdPreferences(){
        return this.idPreferences;
    }

    public void setLanguaje(String languaje){
        this.language = languaje;
    }

    public String getLanguage(){
        return this.language;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    public double getDistance(){
        return this.distance;
    }

    public void setRecomendations(boolean recomendations){
        this.recomendations = recomendations;
    }

    public boolean getRecomendations(){
        return this.recomendations;
    }

    public void setNotificationRecomendation(boolean recomendation){
        this.notificationRecomendations = recomendation;
    }

    public boolean getNotificationsRecomendation(){
        return this.notificationRecomendations;
    }

    public void setNearEventNotification(boolean nearEventNotification){
        this.nearEventNotification = nearEventNotification;
    }

    public boolean getNearNotification(){
        return this.nearEventNotification;
    }

    public void setFavoriteNearNotification(boolean favoriteNearNotification){
        this.favoriteNearNotification = favoriteNearNotification;
    }

    public boolean getFavoriteNearNotification(){
        return this.favoriteNearNotification;
    }

}

package com.movil.boliviaXplore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "notificacion")
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationId")
    private Long notificationId;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "read")
    private boolean read = false;

    @Column(name = "codEvento")
    private Long codEvento;

    @Column(name = "codUsuario")
    private Long codUsuario;

    public Notification(){}
    public Notification(String title, String description, Long codEvent, Long codUser){
        this.title = title;
        this.description = description;
        this.codEvento = codEvent;
        this.codUsuario = codUser;
    }

    public String getDescription(){
        return this.description;
    }

    public Long getUser(){
        return this.codUsuario;
    }

    public Long getEvent(){
        return this.codEvento;
    }

    public String getTitle(){
        return this.title;
    }
}

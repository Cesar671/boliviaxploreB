package com.movil.boliviaXplore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "imagen")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codImagen;

    @Column(length = 200)
    private String nameImage;

    @Column(length = 200)
    private String urlImagen;
    
    private String imageId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Event codEvento;

    public Image(String nameImage, String urlImagen, String imageId, Event evento){
        this.nameImage = nameImage;
        this.urlImagen = urlImagen;
        this.imageId = imageId;
        this.codEvento = evento;
    }

    public long getCodImagen(){
        return this.codImagen;
    }

    public String getNameImage(){
        return this.nameImage;
    }

    public String getUrlImagen(){
        return this.urlImagen;
    }

    public String getImageId(){
        return this.imageId;
    }

    public Event getCodEvento(){
        return this.codEvento;
    }
}

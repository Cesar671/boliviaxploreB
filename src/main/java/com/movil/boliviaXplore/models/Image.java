package com.movil.boliviaXplore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "imagen")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codImagen")
    private long codImagen;

    @Column(name = "nameImagen", length = 200)
    private String nameImage;

    @Column(name = "urlImagen",length = 200)
    private String urlImagen;
    
    @Column(name="imageId")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "codEvento", nullable = false)
    @JsonBackReference("referenceC")
    private Event codEvento;

    

    public Image(String nameImage, String urlImagen, String imageId, Event codEvento){
        this.nameImage = nameImage;
        this.urlImagen = urlImagen;
        this.imageId = imageId;
        this.codEvento = codEvento;
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

package com.movil.boliviaXplore.models;

import org.hibernate.annotations.ManyToAny;

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
    private String urlImagen;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Event codEvento;

}

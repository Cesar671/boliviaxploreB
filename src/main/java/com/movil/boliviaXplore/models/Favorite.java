package com.movil.boliviaXplore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@Table(name = "eventoFavorito", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codUsuario", "codEvento"})
})
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFavorite;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonManagedReference
    private Event codEvento;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(nullable = false)
    private User codUsuario;
}

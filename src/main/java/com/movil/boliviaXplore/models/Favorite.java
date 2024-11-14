package com.movil.boliviaXplore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@Table(name = "eventoFavorito")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFavorite")
    private Long idFavorite;

    @ManyToOne
    @JoinColumn(name = "codEvento", nullable = false)
    @JsonBackReference("referenceB")
    private Event codEvento;

    @ManyToOne
    @JsonBackReference("referenceUserA")
    @JoinColumn(name = "codUsuario", nullable = false)
    private User codUsuario;

    public void setCodEvento(Event event){
        this.codEvento = event;
    }

    public Event getCodEvento(){
        return this.codEvento;
    }

    public void setCodUsuario(User usuario){
        this.codUsuario = usuario;
    }
    
}

package com.movil.boliviaXplore.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "TipoEvento")
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "codTipoEvento")
    private Long idTipoEvento;
    @Column(name = "nombreTipoEvento", unique = true, length = 50)
    private String nombreCategoria;
    @OneToMany(mappedBy = "idTipoEvento", cascade = CascadeType.ALL)
    @JsonManagedReference("referenceA")
    private List<Event> events;

    public Long getIdTipoEvento(){
        return this.idTipoEvento;
    }

    public String getNombreCategoria(){
        return this.nombreCategoria;
    }

    public void setNombreCategoria(String nombre){
        this.nombreCategoria = nombre;
    }

    public List<Event> getEvents(){
        return this.events;
    }
}

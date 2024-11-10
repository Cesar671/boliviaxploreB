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

@Data
@Entity
@Table(name = "TipoEvento")
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long idTipoEvento;
    @Column(unique = true, nullable = false, length = 50)
    private String nombreCategoria;
    @OneToMany(mappedBy = "idTipoEvento", cascade = CascadeType.ALL)
    private List<Event> events;

    public void setNombreCategoria(String nombre){
        this.nombreCategoria = nombre;
    }
}

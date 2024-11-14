package com.movil.boliviaXplore.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "tbl-evento")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codEvento;
    @Column(length = 50)
    private String nombreEvento;
    @Column(length = 100)
    private String descripcionEvento;
    @Column(length = 50)
    private String ubicacion;
    @Column(length = 100)
    private String historiaEvento;
    private Date fechaInicioEvento;
    private Date fechaFinEvento;
    @Column(length = 200)
    private String icon;

    @ManyToOne
    @JsonBackReference("referenceA")
    @JoinColumn(nullable = false)
    private Category idTipoEvento; 

    @OneToMany(mappedBy = "codEvento", cascade = CascadeType.ALL)
    @JsonManagedReference("referenceC")
    private List<Image> imagenes;

    @JsonManagedReference("referenceB")
    @OneToMany(mappedBy = "codEvento", cascade = CascadeType.ALL)
    private List<Favorite> idFavorite;

    public Category getIdTipoEvento(){
        return this.idTipoEvento;
    }

    public long getCodEvento(){
        return this.codEvento;
    }

    public void setCategory(Category cat){
        this.idTipoEvento = cat;
    }

    public String getNombreEvento(){
        return this.nombreEvento;
    }

    @JsonManagedReference
    public List<Image> getImagenes(){
        return this.imagenes;
    }

    public void setNombreEvento(String nombreEvento){
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcionEvento(){
        return this.descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento){
        this.descripcionEvento = descripcionEvento;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public String getUbicacion(){
        return this.ubicacion;
    }

    public String getHistoriaEvento(){
        return this.historiaEvento;
    }

    public String getIcon(){
        return this.icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public void setFechaInicioEvento(Date fechaEvento){
        this.fechaInicioEvento = fechaEvento;
    }

    public void setFechaFinEvento(Date fechaEvento){
        this.fechaFinEvento = fechaEvento;
    }

    public Date getFechaInicioEvento() {
        return this.fechaInicioEvento;
    }

    public Date getFechaFinEvento() {
        return this.fechaFinEvento;
    }
}

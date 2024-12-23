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
import jakarta.persistence.FetchType;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "tbl-evento")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codEvento")
    private Long codEvento;

    @Column(name = "nombreEvento", length = 100)
    private String nombreEvento;

    @Column(name = "ubicacion", length = 200)
    private String ubicacion;

    @Column(name = "descripcionEvento", length = 1000)
    private String descripcionEvento;

    @Column(name = "longitud")
    private double latitud;

    @Column(name = "latitud")
    private double longitud;

    @Column(name = "historiaEvento", length = 1000)
    private String historiaEvento;

    @Column(name = "fechaInicioEvento")
    private Date fechaInicioEvento;

    @Column(name = "fechaFinEvento")
    private Date fechaFinEvento;

    @Column(name = "tipoEvento")
    private String tipoEvento;

    @Column(name = "permanente")
    private boolean permanente;


    @ManyToOne
    @JsonBackReference("referenceA")
    @JoinColumn(name = "idTipoEvento", nullable = false)
    private Category idTipoEvento; 

    @OneToMany(mappedBy = "codEvento", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonManagedReference("referenceC")
    private List<Image> imagenes;

    @JsonManagedReference("referenceB")
    @OneToMany(mappedBy = "codEvento", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Favorite> idFavorite;

    public boolean getPermenente(){
        return this.permanente;
    }

    public void setPermanente(boolean permanente){
        this.permanente = permanente;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public String getUbicacion(){
        return this.ubicacion;
    }

    public Category getIdTipoEvento(){
        return this.idTipoEvento;
    }

    public List<Favorite> getIdFavorite(){
        return this.idFavorite;
    }

    public long getCodEvento(){
        return this.codEvento;
    }

    public String getTipoEvento(){
        return this.tipoEvento;
    }

    public void setTipoEvento(String tipoEvento){
        this.tipoEvento = tipoEvento;
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

    public void setLatitud(double latitud){
        this.latitud = latitud;
    }

    public double getLatitud(){
        return this.latitud;
    }

    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    public double getLongitud(){
        return this.longitud;
    }

    public String getHistoriaEvento(){
        return this.historiaEvento;
    }

    public void setHistoriaEvento(String text){
        this.historiaEvento = text;
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

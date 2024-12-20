package com.movil.boliviaXplore.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.movil.boliviaXplore.DTO.ImageDTO;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Favorite;
import com.movil.boliviaXplore.models.Image;

public class EventDTO{
    private Long codEvento;
    private String nombreEvento;
    private String descripcionEvento;
    private double latitud;
    private double longitud;
    private String historiaEvento;
    private Date fechaInicioEvento;
    private Date fechaFinEvento;
    private Long idTipoEvento;
    private boolean permanente;
    private List<ImageDTO> imagenes;
    private String tipoEvento;
    private List<FavoriteDTO> favorito;

    public EventDTO setFavorito(List<FavoriteDTO> favorites){
        this.favorito = favorito;
        return this;
    };

    public List<FavoriteDTO> getFavorito(){
        return favorito;
    }

    public EventDTO setTipoEvento(String tipoEvento){
        this.tipoEvento = tipoEvento;
        return this;
    }

    public String getTipoEvento(){
        return this.tipoEvento;
    }

    public EventDTO setPermanente(boolean permanente){
        this.permanente = permanente;
        return this;
    }

    public boolean getPermanente(){
        return this.permanente;
    }

    public List<ImageDTO> getImagenes(){
        return this.imagenes;
    }

    public EventDTO setImagenes(List<ImageDTO> imagenes){
        this.imagenes = imagenes;
        return this;
    }

    public EventDTO setIdTipoEvento(Long idTipoEvento){
        this.idTipoEvento = idTipoEvento;
        return this;
    }

    public Long getIdTipoEvento(){
        return this.idTipoEvento;
    }

    public EventDTO setCodEvento(Long codEvento){
        this.codEvento = codEvento;
        return this;
    }

    public Long getCodEvento(){
        return this.codEvento;
    }

    public EventDTO setNombreEvento(String nombreEvento){
        this.nombreEvento = nombreEvento;
        return this;
    }

    public String getNombreEvento(){
        return this.nombreEvento;
    }

    public EventDTO setDescripcionEvento(String descripcionEvento){
        this.descripcionEvento = descripcionEvento;
        return this;
    }

    public String getDescripcionEvento(){
        return this.descripcionEvento;
    }

    public EventDTO setLatitud(double latitud){
        this.latitud = latitud;
        return this;
    }

    public double getLatitud(){
        return this.latitud;
    }

    public EventDTO setLongitud(double longitud){
        this.longitud = longitud;
        return this;
    }

    public double getLongitud(){
        return this.longitud;
    }

    public EventDTO setHistoriaEvento(String historiaEvento){
        this.historiaEvento = historiaEvento;
        return this;
    }

    public String getHistoriaEvento(){
        return this.historiaEvento;
    }

    public EventDTO setFechainicioEvento(Date fechaInicioEvento){
        this.fechaInicioEvento = fechaInicioEvento;
        return this;
    }

    public Date getFechaInicioEvento(){
        return this.fechaInicioEvento;
    }

    public EventDTO setFechaFinEvento(Date fechaFinEvento){
        this.fechaFinEvento = fechaFinEvento;
        return this;
    }

    public Date getFechaFinEvento(){
        return this.fechaFinEvento;
    }

    public static EventDTO getInstance(Event event){
        List<Image> images = event.getImagenes();
        List <ImageDTO> imagesDto = new LinkedList<>();
        for (Image image : images) {
            imagesDto.add(ImageDTO.getInstance(image));
        }
        List<Favorite> favorites = event.getIdFavorite();
        List<FavoriteDTO> favoritesDTO = new LinkedList<>();
        for (Favorite favorite : favorites) {
            favoritesDTO.add(FavoriteDTO.getInstante(favorite));
        }
        return new EventDTO().
                setCodEvento(event.getCodEvento()).
                setNombreEvento(event.getNombreEvento()).
                setDescripcionEvento(event.getDescripcionEvento()).
                setLatitud(event.getLatitud()).
                setLongitud(event.getLongitud()).
                setHistoriaEvento(event.getHistoriaEvento()).
                setFechainicioEvento(event.getFechaInicioEvento()).
                setFechaFinEvento(event.getFechaFinEvento()).
                setIdTipoEvento(event.getIdTipoEvento().getIdTipoEvento()).
                setPermanente(event.getPermenente()).
                setImagenes(imagesDto).
                setTipoEvento(event.getTipoEvento()).
                setFavorito(favoritesDTO);
    }
}

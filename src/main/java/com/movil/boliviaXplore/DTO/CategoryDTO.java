package com.movil.boliviaXplore.DTO;
import java.util.List;

public class CategoryDTO {

    private long idTipoEvento;
    private String nombreCategoria;
    private List<EventDTO> events;

    // Constructor
    public CategoryDTO(long idTipoEvento, String nombreCategoria, List<EventDTO> events) {
        this.idTipoEvento = idTipoEvento;
        this.nombreCategoria = nombreCategoria;
        this.events = events;
    }

    // Getters y Setters
    public long getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(long idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}
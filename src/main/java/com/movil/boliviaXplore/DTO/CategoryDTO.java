package com.movil.boliviaXplore.DTO;

import java.util.LinkedList;
import java.util.List;
import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.models.Event;

public class CategoryDTO {
    private Long idTipoEvento;
    private String nombreCategoria;
    private List<EventDTO> events;

    public CategoryDTO(Long idTipoEvento, String nombreCategoria, List events){
        this.idTipoEvento = idTipoEvento;
        this.nombreCategoria = nombreCategoria;
        this.events = events;
    }

    public void setIdTipoEvento(Long idTipoEvento){
        this.idTipoEvento = idTipoEvento;
    }

    public Long getIdTipoEvento(){
        return this.idTipoEvento;
    }

    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreCategoria(){
        return this.nombreCategoria;
    }

    public void setEvents(List<EventDTO> events){
        this.events = events;
    }

    public List<EventDTO> getEvents(){
        return this.events;
    }

    public static CategoryDTO getInstance(Category category){
        List<Event> events = category.getEvents();
        List<EventDTO> eventsDto = new LinkedList<>();
        for (Event event: events) {
            eventsDto.add(EventDTO.getInstance(event));
        }
        return new CategoryDTO(category.getIdTipoEvento(), category.getNombreCategoria(), eventsDto);
    }
}

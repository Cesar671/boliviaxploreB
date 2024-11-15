package com.movil.boliviaXplore.DTO;

public class EventDTO {

    private long idEvento;
    private String nombreEvento;

    // Constructor
    public EventDTO(long idEvento, String nombreEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
    }

    // Getters y Setters
    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
}

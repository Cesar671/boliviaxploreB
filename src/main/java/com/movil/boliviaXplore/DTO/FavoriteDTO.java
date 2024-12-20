package com.movil.boliviaXplore.DTO;

import com.movil.boliviaXplore.models.Favorite;

public class FavoriteDTO {
    private long idFavorite;
    private long codEvento;
    private long codUsuario;


    public FavoriteDTO setIdFavorite(long idFavorite){
        this.idFavorite = idFavorite;
        return this;
    }

    public long getIdFavorite(){
        return this.idFavorite;
    }

    public FavoriteDTO setCodEvento(long codEvento){
        this.codEvento = codEvento;
        return this;
    }

    public long getCodEvento(){
        return this.codEvento;
    }

    public FavoriteDTO setcodUsuario(long codUsuario){
        this.codUsuario = codUsuario;
        return this;
    }

    public long getCodUsuario(){
        return this.codUsuario;
    }

    public static FavoriteDTO getInstante(Favorite favorite){
        return new FavoriteDTO()
                    .setCodEvento(favorite.getCodEvento().getCodEvento())
                    .setIdFavorite(favorite.getIdFavorite())
                    .setcodUsuario(favorite.getCodUsuario().getCodUsuario());
    }
}

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
import lombok.NoArgsConstructor;
import java.util.List;
import jakarta.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codUsuario")
    private Long codUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "correoUsuario")
    private String correoUsuario;

    @Column(name = "fotoUsuario")
    private String fotoUsuario;

    @Column(name= "rolUsuario")
    private int rolUsuario;

    @Column(name = "googleId")
    private String goodleId;

    @Column(name = "authProvider")
    private String authProvider;

    public void setAuthProvider(String authProvider){
        this.authProvider = authProvider;
    }

    public String getAuthProvider(){
        return this.authProvider;
    }

    public void setGoogleId(String googleId){
        this.goodleId = googleId;
    }

    public String getGoogleId(){
        return this.goodleId;
    }

    @OneToMany(mappedBy = "codUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference("referenceUserA")
    private List<Favorite> idFavorite;

    public void setNombreUsuario(String nombre){
        this.nombreUsuario = nombre;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public void setCorreoUsuario(String correo){
        this.correoUsuario = correo;
    }

    public String getCorreoUsuario(){
        return this.correoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario){
        this.fotoUsuario = fotoUsuario;
    }

    public String getFotoUsuario(){
        return this.fotoUsuario;
    }

    public void setRolUsuario(int rol){
        this.rolUsuario = rol;
    }

    public int getRolUsuario(){
        return this.rolUsuario;
    }

    public Long getCodUsuario(){
        return this.codUsuario;
    }
}

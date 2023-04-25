package com.upc.puppiesvetweb.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Usuario")
    private Long idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String dniUsuario;
    private String celularUsuario;
    private String direccionUsuario;
    private String imagenUsuario;
    private String password;
    private String rol;
    private boolean estado;
    public Usuario(){
    }
    public Usuario(Long idUsuario, String nombreUsuario, String password, boolean estado){
        this.setIdUsuario(idUsuario);
        this.setNombreUsuario(nombreUsuario);
        this.setPassword(password);
        this.setEstado(estado);
    }
}

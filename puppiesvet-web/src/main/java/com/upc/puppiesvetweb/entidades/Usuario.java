package com.upc.puppiesvetweb.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_USUARIO",uniqueConstraints = {@UniqueConstraint(name = "unique_dni_usuario", columnNames = {"dniUsuario"})})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Usuario")
    private Long idUsuario;
    @Column(unique = true)
    private String dniUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String celularUsuario;
    private String direccionUsuario;
    private String imagenUsuario;
    private String password;
    private String rol;
    private boolean estado;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Mascota> lstMascota;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Orden> lstOrden;
    public Usuario(){
        this.setEstado(true);
    }
    public Usuario(Long idUsuario){
        this.setIdUsuario(idUsuario);
    }
    public Usuario(Long idUsuario, String nombreUsuario, String password, boolean estado){
        this.setIdUsuario(idUsuario);
        this.setNombreUsuario(nombreUsuario);
        this.setPassword(password);
        this.setEstado(estado);
    }
}

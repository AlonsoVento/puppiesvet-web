package com.upc.puppiesvetweb.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_ESPECIE_MASCOTA")
public class EspecieMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_EspecieMascota")
    private Long idEspecieMascota;
    private String nombreEspecieMascota;
    private String descripcionEspecieMascota;
    private boolean estado;
    @OneToMany(mappedBy = "especieMascota",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<RazaMascota> lstRazaMascota;
    public EspecieMascota(){
        this.setEstado(true);
    }
    public EspecieMascota(Long idEspecieMascota){
        this.setIdEspecieMascota(idEspecieMascota);
    }
    public EspecieMascota(Long idEspecieMascota, String nombreEspecieMascota, String descripcionEspecieMascota, boolean estado){
        this.setIdEspecieMascota(idEspecieMascota);
        this.setNombreEspecieMascota(nombreEspecieMascota);
        this.setDescripcionEspecieMascota(descripcionEspecieMascota);
        this.setEstado(estado);
    }
}

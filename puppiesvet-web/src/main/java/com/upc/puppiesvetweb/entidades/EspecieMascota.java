package com.upc.puppiesvetweb.entidades;

import com.upc.puppiesvetweb.utils.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_RazaMascota", foreignKey = @ForeignKey(name = "fk_especie_mascota_raza_mascota") )
    private RazaMascota razaMascota;
    public EspecieMascota(){}
    public EspecieMascota(Long idEspecieMascota, String nombreEspecieMascota, String descripcionEspecieMascota, boolean estado){
        this.setIdEspecieMascota(idEspecieMascota);
        this.setNombreEspecieMascota(nombreEspecieMascota);
        this.setDescripcionEspecieMascota(descripcionEspecieMascota);
        this.setEstado(estado);
    }
}

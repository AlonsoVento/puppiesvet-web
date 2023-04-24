package com.upc.puppiesvetweb.entidades;

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

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_RazaMascota", foreignKey = @ForeignKey(name = "fk_especie_mascota_raza_mascota") )
    private RazaMascota razaMascota;
}

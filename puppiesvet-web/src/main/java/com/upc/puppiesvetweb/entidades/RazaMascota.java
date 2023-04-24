package com.upc.puppiesvetweb.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_RAZA_MASCOTA")
public class RazaMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_RazaMascota")
    private Long idRazaMascota;
    private String nombreRazaMascota;
    private String descripcionRazaMascota;
    private String cuidadosRazaMascota;
}

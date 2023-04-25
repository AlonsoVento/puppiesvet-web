package com.upc.puppiesvetweb.entidades;

import com.upc.puppiesvetweb.utils.Constantes;
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
    private boolean estado;
    public RazaMascota(){
    }
}

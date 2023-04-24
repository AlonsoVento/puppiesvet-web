package com.upc.puppiesvetweb.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_SERVICIO")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Servicio")
    private Long idServicio;
    private String nombreServicio;
    private String descripcionServicio;
}

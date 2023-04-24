package com.upc.puppiesvetweb.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TBL_ORDEN")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Orden")
    private Long idOrden;
    private String notaOrden;
    private double pesoMascota;
    private double tamanoMascota;
    private Date fechaOrden;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Mascota", foreignKey = @ForeignKey(name = "fk_orden_mascota") )
    private Mascota mascota;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Servicio", foreignKey = @ForeignKey(name = "fk_orden_servicio") )
    private Servicio servicio;
}

package com.upc.puppiesvetweb.entidades;

import com.upc.puppiesvetweb.utils.Constantes;
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
    private double costoOrden;
    private Date fechaOrden;
    private boolean estado;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Mascota", foreignKey = @ForeignKey(name = "fk_orden_mascota") )
    private Mascota mascota;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Servicio", foreignKey = @ForeignKey(name = "fk_orden_servicio") )
    private Servicio servicio;
    public Orden(){
    }

}

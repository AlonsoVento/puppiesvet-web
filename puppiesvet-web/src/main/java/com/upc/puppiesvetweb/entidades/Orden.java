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
    private String notaOrdenCliente;
    private String notaOrdenMedico;
    private double costoOrden;
    private Date fechaOrden;
    private boolean estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Mascota", foreignKey = @ForeignKey(name = "fk_orden_mascota") )
    private Mascota mascota;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Servicio", foreignKey = @ForeignKey(name = "fk_orden_servicio") )
    private Servicio servicio;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_Usuario", foreignKey = @ForeignKey(name = "fk_orden_usuario") )
    private Usuario usuario;
    public Orden(){
        this.setEstado(true);
    }

}

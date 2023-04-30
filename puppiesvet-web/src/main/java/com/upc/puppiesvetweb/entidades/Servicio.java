package com.upc.puppiesvetweb.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.puppiesvetweb.utils.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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
    private boolean estado;
    @OneToMany(mappedBy = "servicio",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Orden> lstOrden;
    public Servicio(){
        this.setEstado(true);
    }
    public Servicio(Long idServicio){
        this.setIdServicio(idServicio);
    }
}

package com.upc.puppiesvetweb.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.puppiesvetweb.utils.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_MASCOTA")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Mascota")
    private Long idMascota;
    private String nombreMascota;
    private double pesoMascota;
    private double tamanoMascota;
    private Date fechaNacimientoMascota;
    private String imagenMascota;
    private String sexoMascota;
    private boolean estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_RazaMascota", foreignKey = @ForeignKey(name = "fk_mascota_raza_mascota") )
    private RazaMascota razaMascota;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Usuario", foreignKey = @ForeignKey(name = "fk_mascota_usuario") )
    private Usuario usuario;
    @OneToMany(mappedBy = "mascota",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Orden> lstOrden;
    public Mascota(){
        this.setEstado(true);
    }
    public Mascota(Long idMascota){
        this.setIdMascota(idMascota);
    }
}

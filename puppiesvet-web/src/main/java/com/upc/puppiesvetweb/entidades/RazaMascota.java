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
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_EspecieMascota", foreignKey = @ForeignKey(name = "fk_raza_mascota_especie_mascota") )
    private EspecieMascota especieMascota;
    @OneToMany(mappedBy = "razaMascota",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Mascota> lstMascota;
    public RazaMascota(){
        this.setEstado(true);
    }
    public RazaMascota(Long idRazaMascota){
        this.setIdRazaMascota(idRazaMascota);
    }
}

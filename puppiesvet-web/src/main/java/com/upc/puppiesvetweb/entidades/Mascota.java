package com.upc.puppiesvetweb.entidades;

import com.upc.puppiesvetweb.utils.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_EspecieMascota", foreignKey = @ForeignKey(name = "fk_mascota_especie_mascota") )
    private EspecieMascota especieMascota;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Usuario", foreignKey = @ForeignKey(name = "fk_mascota_usuario") )
    private Usuario usuario;
    public Mascota(){}
}

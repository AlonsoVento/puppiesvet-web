package com.upc.puppiesvetweb.entidades;


import jakarta.persistence.*;

import java.awt.image.BufferedImage;

@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_Usuario;
    private String nombre_Usuario;
    private String email_Usuario;
    private String dni_Usuario;
    private String celular_Usuario;
    private String direccion_Usuario;
    private BufferedImage imagen;
    private String password;
}

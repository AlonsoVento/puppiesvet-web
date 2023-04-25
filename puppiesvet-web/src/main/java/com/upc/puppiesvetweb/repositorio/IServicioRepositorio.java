package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepositorio extends JpaRepository<Servicio,Long> {
}

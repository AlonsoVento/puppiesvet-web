package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.EspecieMascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecieMascotaRepositorio extends JpaRepository<EspecieMascota,Long> {
}

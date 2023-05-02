package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.EspecieMascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEspecieMascotaRepositorio extends JpaRepository<EspecieMascota,Long> {
    public List<EspecieMascota> findAllByEstadoIsTrue();
}

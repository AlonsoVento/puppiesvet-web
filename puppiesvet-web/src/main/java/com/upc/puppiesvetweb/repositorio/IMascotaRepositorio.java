package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMascotaRepositorio extends JpaRepository<Mascota,Long> {
    public List<Mascota> findAllByEstadoIsTrue();
}

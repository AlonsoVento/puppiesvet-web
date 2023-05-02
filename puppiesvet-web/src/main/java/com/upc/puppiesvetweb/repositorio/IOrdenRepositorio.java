package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrdenRepositorio extends JpaRepository<Orden,Long> {
    public List<Orden> findAllByEstadoIsTrue();
}

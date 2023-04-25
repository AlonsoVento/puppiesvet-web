package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepositorio extends JpaRepository<Orden,Long> {
}

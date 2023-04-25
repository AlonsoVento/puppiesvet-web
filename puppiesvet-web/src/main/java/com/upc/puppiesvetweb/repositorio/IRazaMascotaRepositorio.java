package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.RazaMascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRazaMascotaRepositorio extends JpaRepository<RazaMascota,Long> {
}

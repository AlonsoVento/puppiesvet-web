package com.upc.puppiesvetweb.repositorio;

import com.upc.puppiesvetweb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepositorio extends JpaRepository<Usuario,Long> {
    public Optional<Usuario> findByNombreUsuarioEqualsAndPasswordEquals(String nombreUsuario, String password);
    public Optional<Usuario> findByDniUsuarioEqualsAndPasswordEquals(String dniUsuario,String password);

    public List<Usuario> findAllByEstadoIsTrueAndRolEquals(String rol);
    public List<Usuario> findAllByEstadoIsTrue();
}

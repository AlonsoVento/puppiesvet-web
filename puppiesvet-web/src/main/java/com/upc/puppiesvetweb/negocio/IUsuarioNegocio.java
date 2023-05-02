package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Usuario;

import java.util.List;

public interface IUsuarioNegocio {
    public Usuario registrar(Usuario usuario);
    public Usuario buscar(Long id) throws Exception;
    public List<Usuario> listado();
    public Usuario actualizar(Usuario usuario) throws Exception;
    public Usuario buscarPorDniPassword(String dniUsuario, String password) throws Exception;
    public List<Usuario> listadoActivosAndRol(String rol);
    public List<Usuario> listadoActivos();
}

package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Usuario;
import com.upc.puppiesvetweb.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioNegocio implements IUsuarioNegocio{
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;
    @Override
    public Usuario registrar(Usuario usuario) {
        return iUsuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscar(Long id) throws Exception {
        return iUsuarioRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<Usuario> listado() {
        return iUsuarioRepositorio.findAll();
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws Exception {
        buscar(usuario.getIdUsuario());
        return iUsuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarPorDniPassword(String dniUsuario, String password) throws Exception {
        return iUsuarioRepositorio.findByDniUsuarioEqualsAndPasswordEquals(dniUsuario,password).orElseThrow(()->new Exception("No se encontro usuario con la contraseña provista"));
    }
}

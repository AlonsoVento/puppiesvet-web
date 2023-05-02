package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Orden;
import com.upc.puppiesvetweb.repositorio.IOrdenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrdenNegocio implements IOrdenNegocio{
    @Autowired
    IOrdenRepositorio iOrdenRepositorio;
    @Override
    public Orden registrar(Orden orden) {
        return iOrdenRepositorio.save(orden);
    }

    @Override
    public Orden buscar(Long id) throws Exception {
        return iOrdenRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<Orden> listado() {
        return iOrdenRepositorio.findAll();
    }

    @Override
    public Orden actualizar(Orden orden) throws Exception {
        buscar(orden.getIdOrden());
        return iOrdenRepositorio.save(orden);
    }

    @Override
    public List<Orden> listadoActivos() {
        return iOrdenRepositorio.findAllByEstadoIsTrue();
    }

    @Override
    public List<Orden> listadoPorUsuarioMascota(Long idUsuarioMascota) {
        List<Orden> ordenListOutput = new ArrayList<>();
        for( Orden orden: listadoActivos() ){
            if(orden.getMascota().getUsuario().getIdUsuario().equals(idUsuarioMascota)){
                ordenListOutput.add(orden);
            }
        }
        return ordenListOutput;
    }

    @Override
    public List<Orden> listadoPorUsuarioAtiende(Long idUsuario) {
        List<Orden> ordenListOutput = new ArrayList<>();
        for( Orden orden: listadoActivos() ){
            if(orden.getUsuario().getIdUsuario().equals(idUsuario)){
                ordenListOutput.add(orden);
            }
        }
        return ordenListOutput;
    }
}

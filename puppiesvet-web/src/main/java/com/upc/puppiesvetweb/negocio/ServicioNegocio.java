package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Servicio;
import com.upc.puppiesvetweb.repositorio.IServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioNegocio implements IServicioNegocio{
    @Autowired
    IServicioRepositorio iServicioRepositorio;
    @Override
    public Servicio registrar(Servicio servicio) {
        return iServicioRepositorio.save(servicio);
    }

    @Override
    public Servicio buscar(Long id) throws Exception {
        return iServicioRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<Servicio> listado() {
        return iServicioRepositorio.findAll();
    }

    @Override
    public Servicio actualizar(Servicio servicio) throws Exception {
        buscar(servicio.getIdServicio());
        return iServicioRepositorio.save(servicio);
    }

    @Override
    public List<Servicio> listadoActivos() {
        return iServicioRepositorio.findAllByEstadoIsTrue();
    }
}

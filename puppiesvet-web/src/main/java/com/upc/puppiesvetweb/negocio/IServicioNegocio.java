package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Servicio;

import java.util.List;

public interface IServicioNegocio {
    public Servicio registrar(Servicio servicio);
    public Servicio buscar(Long id) throws Exception;
    public List<Servicio> listado();
    public Servicio actualizar(Servicio servicio) throws Exception;
}

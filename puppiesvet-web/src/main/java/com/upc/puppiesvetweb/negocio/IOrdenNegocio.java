package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Orden;

import java.util.List;

public interface IOrdenNegocio {
    public Orden registrar(Orden orden);
    public Orden buscar(Long id) throws Exception;
    public List<Orden> listado();
    public Orden actualizar(Orden orden) throws Exception;
}

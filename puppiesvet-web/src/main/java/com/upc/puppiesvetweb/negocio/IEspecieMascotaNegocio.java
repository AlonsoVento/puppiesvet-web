package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.EspecieMascota;

import java.util.List;

public interface IEspecieMascotaNegocio {
    public EspecieMascota registrar(EspecieMascota especieMascota);
    public EspecieMascota buscar(Long id) throws Exception;
    public List<EspecieMascota> listado();
    public EspecieMascota actualizar(EspecieMascota especieMascota) throws Exception;
    public List<EspecieMascota> listadoActivos();
}

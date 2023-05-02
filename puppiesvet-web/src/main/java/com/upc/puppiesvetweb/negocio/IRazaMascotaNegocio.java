package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.RazaMascota;

import java.util.List;

public interface IRazaMascotaNegocio {
    public RazaMascota registrar(RazaMascota razaMascota);
    public RazaMascota buscar(Long id) throws Exception;
    public List<RazaMascota> listado();
    public RazaMascota actualizar(RazaMascota razaMascota) throws Exception;
    public List<RazaMascota> listadoActivos();
    public List<RazaMascota> listadoActivosAndEspecie(Long idEspecieMascota);
}

package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Mascota;
import com.upc.puppiesvetweb.entidades.Orden;

import java.util.List;

public interface IMascotaNegocio {
    public Mascota registrar(Mascota mascota);
    public Mascota buscar(Long id) throws Exception;
    public List<Mascota> listado();
    public Mascota actualizar(Mascota mascota) throws Exception;
    public List<Mascota> listadoActivos();
    public List<Mascota> listadoPorUsuarioMascota(Long idUsuarioMascota);
}

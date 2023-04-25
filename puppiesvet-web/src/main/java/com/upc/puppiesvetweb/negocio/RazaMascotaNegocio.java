package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.RazaMascota;
import com.upc.puppiesvetweb.repositorio.IRazaMascotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RazaMascotaNegocio implements IRazaMascotaNegocio{
    @Autowired
    IRazaMascotaRepositorio iRazaMascotaRepositorio;
    @Override
    public RazaMascota registrar(RazaMascota razaMascota) {
        return iRazaMascotaRepositorio.save(razaMascota);
    }

    @Override
    public RazaMascota buscar(Long id) throws Exception {
        return iRazaMascotaRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<RazaMascota> listado() {
        return iRazaMascotaRepositorio.findAll();
    }

    @Override
    public RazaMascota actualizar(RazaMascota razaMascota) throws Exception {
        buscar(razaMascota.getIdRazaMascota());
        return iRazaMascotaRepositorio.save(razaMascota);
    }
}

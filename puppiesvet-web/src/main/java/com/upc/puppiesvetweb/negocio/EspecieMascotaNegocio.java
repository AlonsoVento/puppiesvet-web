package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.EspecieMascota;
import com.upc.puppiesvetweb.repositorio.IEspecieMascotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspecieMascotaNegocio implements IEspecieMascotaNegocio{
    @Autowired
    IEspecieMascotaRepositorio iEspecieMascotaRepositorio;
    @Override
    public EspecieMascota registrar(EspecieMascota especieMascota) {
        return iEspecieMascotaRepositorio.save(especieMascota);
    }

    @Override
    public EspecieMascota buscar(Long id) throws Exception {
        return iEspecieMascotaRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<EspecieMascota> listado() {
        return iEspecieMascotaRepositorio.findAll();
    }

    @Override
    public EspecieMascota actualizar(EspecieMascota especieMascota) throws Exception {
        buscar(especieMascota.getIdEspecieMascota());
        return iEspecieMascotaRepositorio.save(especieMascota);
    }
}

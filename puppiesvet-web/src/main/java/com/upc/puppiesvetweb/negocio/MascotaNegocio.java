package com.upc.puppiesvetweb.negocio;

import com.upc.puppiesvetweb.entidades.Mascota;
import com.upc.puppiesvetweb.repositorio.IMascotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaNegocio implements IMascotaNegocio{
    @Autowired
    IMascotaRepositorio iMascotaRepositorio;
    @Override
    public Mascota registrar(Mascota mascota) {
        return iMascotaRepositorio.save(mascota);
    }

    @Override
    public Mascota buscar(Long id) throws Exception {
        return iMascotaRepositorio.findById(id).orElseThrow(()->new Exception("No se encontro entidad buscada"));
    }

    @Override
    public List<Mascota> listado() {
        return iMascotaRepositorio.findAll();
    }

    @Override
    public Mascota actualizar(Mascota mascota) throws Exception {
        buscar(mascota.getIdMascota());
        return iMascotaRepositorio.save(mascota);
    }
}

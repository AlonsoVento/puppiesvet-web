package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.EspecieMascota;
import com.upc.puppiesvetweb.negocio.IEspecieMascotaNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class EspecieMascotaRest {
    @Autowired
    private IEspecieMascotaNegocio iEspecieMascotaNegocio;
    Logger logger = LoggerFactory.getLogger(EspecieMascotaRest.class);
    @GetMapping("/especie_mascota")
    public List<EspecieMascota> listado(){
        return iEspecieMascotaNegocio.listado();
    }
    @GetMapping("/especie_mascota_active")
    public List<EspecieMascota> listadoActivos(){
        return iEspecieMascotaNegocio.listadoActivos();
    }
    @PostMapping("/especie_mascota")
    public EspecieMascota registrar(@RequestBody EspecieMascota especieMascota){
        return iEspecieMascotaNegocio.registrar(especieMascota);
    }
    @GetMapping("/especie_mascota/{id}")
    public EspecieMascota buscar(@PathVariable(value = "id") Long id){
        try {
            return iEspecieMascotaNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @PutMapping("/especie_mascota/{id}")
    public EspecieMascota actualizar(@RequestBody EspecieMascota especieMascota){
        try {
            return iEspecieMascotaNegocio.actualizar(especieMascota);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

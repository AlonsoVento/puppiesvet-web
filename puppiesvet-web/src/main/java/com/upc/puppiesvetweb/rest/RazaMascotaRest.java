package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.RazaMascota;
import com.upc.puppiesvetweb.negocio.IRazaMascotaNegocio;
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
public class RazaMascotaRest {
    @Autowired
    private IRazaMascotaNegocio iRazaMascotaNegocio;
    Logger logger = LoggerFactory.getLogger(RazaMascotaRest.class);
    @GetMapping("/raza_mascota")
    public List<RazaMascota> listado(){
        return iRazaMascotaNegocio.listado();
    }
    @GetMapping("/raza_mascota/especie/{id}")
    public List<RazaMascota> buscarPorEspecie(@PathVariable(value = "id") Long id){
        return iRazaMascotaNegocio.listadoActivosAndEspecie(id);
    }
    @PostMapping("/raza_mascota")
    public RazaMascota registrar(@RequestBody RazaMascota razaMascota){
        return iRazaMascotaNegocio.registrar(razaMascota);
    }
    @GetMapping("/raza_mascota/{id}")
    public RazaMascota buscar(@PathVariable(value = "id") Long id){
        try {
            return iRazaMascotaNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @PutMapping("/raza_mascota/{id}")
    public RazaMascota actualizar(@RequestBody RazaMascota razaMascota){
        try {
            return iRazaMascotaNegocio.actualizar(razaMascota);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.Mascota;
import com.upc.puppiesvetweb.negocio.IMascotaNegocio;
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
public class MascotaRest {
    @Autowired
    private IMascotaNegocio iMascotaNegocio;
    Logger logger = LoggerFactory.getLogger(MascotaRest.class);
    @GetMapping("/mascota")
    public List<Mascota> listado(){
        return iMascotaNegocio.listado();
    }
    @PostMapping("/mascota")
    public Mascota registrar(@RequestBody Mascota mascota){
        return iMascotaNegocio.registrar(mascota);
    }
    @GetMapping("/mascota/{id}")
    public Mascota buscar(@PathVariable(value = "id") Long id){
        try {
            return iMascotaNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @PutMapping("/mascota/{id}")
    public Mascota actualizar(@RequestBody Mascota mascota){
        try {
            return iMascotaNegocio.actualizar(mascota);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

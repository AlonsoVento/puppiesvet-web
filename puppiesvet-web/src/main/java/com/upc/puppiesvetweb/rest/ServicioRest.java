package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.Servicio;
import com.upc.puppiesvetweb.negocio.IServicioNegocio;
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
public class ServicioRest {
    @Autowired
    private IServicioNegocio iServicioNegocio;
    Logger logger = LoggerFactory.getLogger(ServicioRest.class);
    @GetMapping("/servicio")
    public List<Servicio> listado(){
        return iServicioNegocio.listado();
    }
    @PostMapping("/servicio")
    public Servicio registrar(@RequestBody Servicio usuario){
        return iServicioNegocio.registrar(usuario);
    }
    @GetMapping("/servicio/{id}")
    public Servicio buscar(@PathVariable(value = "id") Long id){
        try {
            return iServicioNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @PutMapping("/servicio/{id}")
    public Servicio actualizar(@RequestBody Servicio servicio){
        try {
            return iServicioNegocio.actualizar(servicio);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

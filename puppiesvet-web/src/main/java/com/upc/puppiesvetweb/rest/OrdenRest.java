package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.Orden;
import com.upc.puppiesvetweb.negocio.IOrdenNegocio;
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
public class OrdenRest {
    @Autowired
    private IOrdenNegocio iOrdenNegocio;
    Logger logger = LoggerFactory.getLogger(OrdenRest.class);
    @GetMapping("/orden")
    public List<Orden> listado(){
        return iOrdenNegocio.listado();
    }

    @PostMapping("/orden")
    public Orden registrar(@RequestBody Orden orden){
        return iOrdenNegocio.registrar(orden);
    }
    @GetMapping("/orden/cliente/{id}")
    public List<Orden> buscarPorCliente(@PathVariable(value = "id") Long id){
        return iOrdenNegocio.listadoPorUsuarioMascota(id);
    }

    @GetMapping("/orden/admin/{id}")
    public List<Orden> buscarPorAdministrador(@PathVariable(value = "id") Long id){
        return iOrdenNegocio.listadoPorUsuarioAtiende(id);
    }

    @GetMapping("/orden/{id}")
    public Orden buscar(@PathVariable(value = "id") Long id){
        try {
            return iOrdenNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }

    @PutMapping("/orden/{id}")
    public Orden actualizar(@RequestBody Orden orden){
        try {
            return iOrdenNegocio.actualizar(orden);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

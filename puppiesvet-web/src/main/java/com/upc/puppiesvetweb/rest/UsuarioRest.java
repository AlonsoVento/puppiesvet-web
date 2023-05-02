package com.upc.puppiesvetweb.rest;

import com.upc.puppiesvetweb.entidades.Usuario;
import com.upc.puppiesvetweb.negocio.IUsuarioNegocio;
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
public class UsuarioRest {
    @Autowired
    private IUsuarioNegocio iUsuarioNegocio;
    Logger logger = LoggerFactory.getLogger(UsuarioRest.class);
    @GetMapping("/usuario")
    public List<Usuario> listado(){
        return iUsuarioNegocio.listado();
    }
    @GetMapping("/usuario_active")
    public List<Usuario> listadoActivos(){
        return iUsuarioNegocio.listadoActivos();
    }
    @GetMapping("/usuario/rol/{rol}")
    public List<Usuario> listadoActivosPorRol(@PathVariable(value = "rol") String rol){
        return iUsuarioNegocio.listadoActivosAndRol(rol);
    }
    @PostMapping("/usuario")
    public Usuario registrar(@RequestBody Usuario usuario){
        return iUsuarioNegocio.registrar(usuario);
    }
    @GetMapping("/usuario/{id}")
    public Usuario buscar(@PathVariable(value = "id") Long id){
        try {
            return iUsuarioNegocio.buscar(id);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @PutMapping("/usuario/{id}")
    public Usuario actualizar(@RequestBody Usuario usuario){
        try {
            return iUsuarioNegocio.actualizar(usuario);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
    @GetMapping("/usuario/dni={dniUsuario}&&password={password}")
    public Usuario autenticar(@PathVariable(value = "dniUsuario") String dniUsuario,
                              @PathVariable(value = "password") String password){
        try {
            return iUsuarioNegocio.buscarPorDniPassword(dniUsuario,password);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}

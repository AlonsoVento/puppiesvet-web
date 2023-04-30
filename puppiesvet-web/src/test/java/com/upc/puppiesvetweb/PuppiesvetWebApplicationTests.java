package com.upc.puppiesvetweb;

import com.upc.puppiesvetweb.entidades.*;
import com.upc.puppiesvetweb.negocio.*;
import com.upc.puppiesvetweb.utils.Constantes;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class PuppiesvetWebApplicationTests {
	@Autowired
	private IServicioNegocio iServicioNegocio;
	@Autowired
	private IUsuarioNegocio iUsuarioNegocio;
	@Autowired
	private IEspecieMascotaNegocio iEspecieMascotaNegocio;
	@Autowired
	private IRazaMascotaNegocio iRazaMascotaNegocio;
	@Autowired
	private IMascotaNegocio iMascotaNegocio;
	@Autowired
	private IOrdenNegocio iOrdenNegocio;
	@Test
	void contextLoads() {
	}
	@Test
	void a_testRegistro(){
		Servicio servicio = new Servicio();
		servicio.setNombreServicio("Desparasitación");
		servicio.setDescripcionServicio("Servicio para desparasitación de mascotas");
		iServicioNegocio.registrar(servicio);

		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Luis Romero Levano");
		usuario.setPassword("123456");
		usuario.setCelularUsuario("981535844");
		usuario.setDniUsuario("74134578");
		usuario.setDireccionUsuario("Av. Siempreviva 123");
		usuario.setEmailUsuario("lromero@upc.edu.pe");
		usuario.setRol(Constantes.ROL_ADMINISTRADOR);
		iUsuarioNegocio.registrar(usuario);

		EspecieMascota especieMascota = new EspecieMascota();
		especieMascota.setNombreEspecieMascota("Perro");
		especieMascota.setDescripcionEspecieMascota("Caninos");
		iEspecieMascotaNegocio.registrar(especieMascota);

	}

	@Test
	void b_testRegistro(){

		try {
			RazaMascota razaMascota = new RazaMascota();
			razaMascota.setNombreRazaMascota("Cocker Spaniel");
			razaMascota.setDescripcionRazaMascota("Cocker Spaniel Inglés");
			razaMascota.setCuidadosRazaMascota("Ninguno indicado");
			razaMascota.setEspecieMascota(new EspecieMascota(1L));
			iRazaMascotaNegocio.registrar(razaMascota);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	void c_testRegistro(){
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Jorge Marin Canta");
		usuario.setPassword("123456");
		usuario.setCelularUsuario("985786325");
		usuario.setDniUsuario("66985421");
		usuario.setDireccionUsuario("Av. Siempreviva 123");
		usuario.setEmailUsuario("jmarin@upc.edu.pe");
		usuario.setRol(Constantes.ROL_CLIENTE);
		iUsuarioNegocio.registrar(usuario);
	}
	@Test
	void d_testRegistro(){

		try {
			Mascota mascota = new Mascota();
			mascota.setNombreMascota("Tobi");
			mascota.setPesoMascota(12.4);
			mascota.setSexoMascota(Constantes.SEXO_MASCULINO);
			mascota.setTamanoMascota(45);
			String sDate1="20/04/2022";
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			mascota.setFechaNacimientoMascota( date1 );
			mascota.setRazaMascota(new RazaMascota(1L));
			mascota.setUsuario(new Usuario(2L));
			iMascotaNegocio.registrar(mascota);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	void e_testRegistro(){

		try {
			Orden orden = new Orden();
			String sDate1="29/04/2023";
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			orden.setFechaOrden(date1);
			orden.setNotaOrdenCliente("Necesito este servicio para mi mascota para tal...");
			orden.setServicio(new Servicio(1L));
			orden.setMascota(new Mascota(1L));
			iOrdenNegocio.registrar(orden);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	void f_testRegistro(){

		try {
			Orden orden = iOrdenNegocio.buscar(1L);
			orden.setNotaOrdenMedico("Se realizaron los servicios de tal tal");
			orden.setUsuario(new Usuario(1L));
			orden.setCostoOrden(20);
			iOrdenNegocio.actualizar(orden);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

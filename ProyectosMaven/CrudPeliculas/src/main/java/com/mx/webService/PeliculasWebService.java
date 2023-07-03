package com.mx.webService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.conection.Resultado;
import com.mx.dao.Implementacion;
import com.mx.entity.Peliculas;

// Estereotipos o anotaciones
@Path("PeliculasWebService")
public class PeliculasWebService {

	// Instancia de clase
	Implementacion imp = new Implementacion();

	// Peticiones con el protocolo http ----- url o endpoint
	// URL -- > url del servidor local + nombre del proyecto en minusculas + Path de
	// la clase + Path del metodo

	// Listar
	// http://localhost:9006/CrudPeliculas/crudPeliculas/PeliculasWebService/listar

	@Path("listar")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Object> listar() {
		List<Object> listPeli = new ArrayList<Object>();
		listPeli = imp.listar();
		return listPeli;
	}

	// Guardar
	// http://localhost:9006/CrudPeliculas/crudPeliculas/PeliculasWebService/guardar

	@Path("guardar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Resultado guardar(Peliculas pelicula) {
		// Instancia de clase
		Resultado rs = new Resultado();
		rs.setObj(pelicula);
		String peli = imp.guardar(pelicula);

		if (peli.equals("1")) {
			rs.setMensaje("Pelicula guardada");
			rs.setRespuesta(peli);
		} else {
			rs.setMensaje("No se guardo");
			rs.setRespuesta(peli);
		}
		return rs;
	}

	// Buscar
	// http://localhost:9006/CrudPeliculas/crudPeliculas/PeliculasWebService/buscar

	@Path("buscar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Peliculas buscar(Peliculas pelicula) {
		imp = new Implementacion();
		pelicula = (Peliculas) imp.buscar(pelicula);
		return pelicula;
	}

	// Editar
	// http://localhost:9006/CrudPeliculas/crudPeliculas/PeliculasWebService/editar

	@Path("editar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Resultado editar(Peliculas pelicula) {
		// Instancia de clase
		Resultado rs = new Resultado();
		rs.setObj(pelicula);
		String peli = imp.editar(pelicula);

		if (peli.equals("1")) {
			rs.setMensaje("Pelicula editada");
			rs.setRespuesta(peli);
		} else {
			rs.setMensaje("No se edito");
			rs.setRespuesta(peli);
		}
		return rs;
	}

	// Eliminar
	// http://localhost:9006/CrudPeliculas/crudPeliculas/PeliculasWebService/eliminar

	@Path("eliminar")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Resultado eliminar(Peliculas pelicula) {
		// Instancia de clase
		Resultado rs = new Resultado();
		rs.setObj(pelicula);
		String peli = imp.eliminar(pelicula);

		if (peli.equals("1")) {
			rs.setMensaje("Pelicula eliminada");
			rs.setRespuesta(peli);
		} else {
			rs.setMensaje("No se elimino");
			rs.setRespuesta(peli);
		}
		return rs;
	}

}

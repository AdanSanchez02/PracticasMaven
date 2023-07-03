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
import com.mx.entity.Herramientas;

@Path("HerramientasWebService")
public class HerramientasWebService {
	
	// Instancia de clase
		Implementacion imp = new Implementacion();

		// Peticiones con el protocolo http ----- url o endpoint
		// URL -- > url del servidor local + nombre del proyecto en minusculas + Path de
		// la clase + Path del metodo

		// Listar
		//http://localhost:9006/CrudHerramientas/crudHerramientas/HerramientasWebService/listar

		@Path("listar")
		@GET
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public List<Object> listar() {
			List<Object> listHerra = new ArrayList<Object>();
			listHerra = imp.listar();
			return listHerra;
		}

		// Guardar
		// http://localhost:9006/CrudHerramientas/crudHerramientas/HerramientasWebService/guardar

		@Path("guardar")
		@POST
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public Resultado guardar(Herramientas herramienta) {
			// Instancia de clase
			Resultado rs = new Resultado();
			rs.setObj(herramienta);
			String peli = imp.guardar(herramienta);

			if (peli.equals("1")) {
				rs.setMensaje("Herramienta guardada");
				rs.setRespuesta(peli);
			} else {
				rs.setMensaje("No se guardo");
				rs.setRespuesta(peli);
			}
			return rs;
		}

		// Buscar
		// http://localhost:9006/CrudHerramientas/crudHerramientas/HerramientasWebService/buscar

		@Path("buscar")
		@POST
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public Herramientas buscar(Herramientas pelicula) {
			imp = new Implementacion();
			pelicula = (Herramientas) imp.buscar(pelicula);
			return pelicula;
		}

		// Editar
		// http://localhost:9006/CrudHerramientas/crudHerramientas/HerramientasWebService/editar

		@Path("editar")
		@POST
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public Resultado editar(Herramientas herramienta) {
			// Instancia de clase
			Resultado rs = new Resultado();
			rs.setObj(herramienta);
			String peli = imp.editar(herramienta);

			if (peli.equals("1")) {
				rs.setMensaje("Herramienta editada");
				rs.setRespuesta(peli);
			} else {
				rs.setMensaje("No se edito");
				rs.setRespuesta(peli);
			}
			return rs;
		}

		// Eliminar
		// http://localhost:9006/CrudHerramientas/crudHerramientas/HerramientasWebService/eliminar

		@Path("eliminar")
		@POST
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public Resultado eliminar(Herramientas herramienta) {
			// Instancia de clase
			Resultado rs = new Resultado();
			rs.setObj(herramienta);
			String her = imp.eliminar(herramienta);

			if (her.equals("1")) {
				rs.setMensaje("Herramienta eliminada");
				rs.setRespuesta(her);
			} else {
				rs.setMensaje("No se elimino");
				rs.setRespuesta(her);
			}
			return rs;
		}

}

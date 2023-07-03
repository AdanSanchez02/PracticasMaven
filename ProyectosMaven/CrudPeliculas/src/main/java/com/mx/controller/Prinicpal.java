package com.mx.controller;

import com.mx.dao.Implementacion;
import com.mx.entity.Peliculas;

public class Prinicpal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Peliculas pelicula;
		// Instanciar la clase implementacion
		Implementacion imp = new Implementacion();

		// Listar
		System.out.println("La lista contiene: " + imp.listar());

		// Guardar
		pelicula = new Peliculas(2, "Los Minioms", "Infantil", 7200000, "Jorge", 240, 0);
		 imp.guardar(pelicula);

		// Buscar
		pelicula = new Peliculas(2);
		pelicula = (Peliculas) imp.buscar(pelicula);
		System.out.println(pelicula);
		
		// Editar
		pelicula = new Peliculas(2);
		pelicula = (Peliculas) imp.buscar(pelicula);
		System.out.println(pelicula);
		pelicula.setNombre("Barney");
		imp.editar(pelicula);
		
		// Eliminar
		pelicula = new Peliculas(3);
		pelicula = (Peliculas) imp.buscar(pelicula);
		System.out.println(pelicula);
		imp.eliminar(pelicula);
		
	}

}

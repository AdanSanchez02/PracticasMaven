package com.mx.controller;

import com.mx.dao.Implementacion;
import com.mx.entity.Herramientas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implementacion imp = new Implementacion();
		Herramientas herramienta;
		// Listar
		System.out.println("La lista contiene: " + imp.listar());

		// Guardar
		// VALUES(3, 'Mecanica', 'Rotamartillo', 'Mediana 15 n', 10250, 1, 5);
		herramienta = new Herramientas(4, "Electricas", "MultiToll", "XR", 2000, 2, 7);
		imp.guardar(herramienta);

		// Listar
		System.out.println("La lista contiene: " + imp.listar());

		// Buscar
		herramienta = new Herramientas(2);
		herramienta = (Herramientas) imp.buscar(herramienta);
		System.out.println(herramienta);

		// Editar
		herramienta = new Herramientas(3);
		herramienta = (Herramientas) imp.buscar(herramienta);
		System.out.println(herramienta);
		herramienta.setNombre("Taladrora");
		imp.editar(herramienta);

		// Eliminar
		herramienta = new Herramientas(2);
		herramienta = (Herramientas) imp.buscar(herramienta);
		System.out.println(imp.eliminar(herramienta));

	}

}

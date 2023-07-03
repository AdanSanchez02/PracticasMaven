package com.mx.entity;

public class Peliculas {
	/*
	 * ID NUMBER PRIMARY KEY NOT NULL, NOMBRE NVARCHAR2(20), GENERO NVARCHAR2(20),
	 * DURACION NVARCHAR2(20), ACTOR NVARCHAR2(20), PRECIO NUMBER, ESTATUS NUMBER
	 */
	// Atributos
	int id;
	String nombre;
	String genero;
	double duracion;
	String actor;
	float precio;
	int status;

	public Peliculas() {

	}
	
	

	public Peliculas(int id) {
		this.id = id;
	}



	public Peliculas(int id, String nombre, String genero, double duracion, String actor, float precio, int status) {

		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.actor = actor;
		this.precio = precio;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", duracion=" + duracion
				+ ", actor=" + actor + ", precio=" + precio + ", status=" + status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

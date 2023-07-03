package com.mx.entity;

public class Herramientas {
	int id;
	String tipo;
	String nombre;
	String tamano;
	double precio;
	int cantidad;
	int existencia;

	public Herramientas() {
	}

	public Herramientas(int id) {
		this.id = id;
	}

	public Herramientas(int id, String tipo, String nombre, String tamano, double precio, int cantidad,
			int existencia) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
		this.cantidad = cantidad;
		this.existencia = existencia;
	}

	@Override
	public String toString() {
		return "Herramientas [id=" + id + ", " + (tipo != null ? "tipo=" + tipo + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "") + (tamano != null ? "tamano=" + tamano + ", " : "")
				+ "precio=" + precio + ", cantidad=" + cantidad + ", existencia=" + existencia + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

}

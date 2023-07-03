package com.mx.conection;

import java.util.List;

public interface Metodos {

	public String guardar(Object obj);

	public String editar(Object obj);

	public String eliminar(Object obj);

	public Object buscar(Object obj);

	public List<Object> listar();

}

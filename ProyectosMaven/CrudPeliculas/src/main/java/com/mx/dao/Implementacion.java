package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.conection.ConexioBD;
import com.mx.conection.Metodos;
import com.mx.entity.Peliculas;

public class Implementacion implements Metodos {

	ConexioBD bd = new ConexioBD();
	Peliculas pelicula;
	// iniciar con el listar para comprobar la conexion

	@Override
	public String guardar(Object obj) {
		// TODO Auto-generated method stub
		// CASTEO
		pelicula = (Peliculas) obj;

		// Declarar variable para la conexion de BD
		Connection conexion;

		// Declarar variable para abrir la conexion
		PreparedStatement pst;

		// Query o codigo sql para guardar
		String query = "INSERT INTO PELICULAS_CINE VALUES(?,?,?,?,?,?,?)";

		// Recibir la respuesta del sevidor
		String resultado = null;
		try {
			// Cargar el controlador - Es el driver de conexion
			Class.forName(bd.getDriver());
			// Conexion a la base de datos
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			// Abrimos la conexion
			pst = conexion.prepareStatement(query);

			// Pasar los campos de nuestra tabla
			pst.setInt(1, pelicula.getId());
			pst.setString(2, pelicula.getNombre());
			pst.setString(3, pelicula.getGenero());
			pst.setDouble(4, pelicula.getDuracion());
			pst.setString(5, pelicula.getActor());
			pst.setFloat(6, pelicula.getPrecio());
			pst.setInt(7, pelicula.getStatus());

			// Ejecutamos la sentencia
			int insert = pst.executeUpdate();

			if (insert > 0) {
				resultado = "1";
				System.out.println("Se guardo correctamente " + resultado);

			} else {
				resultado = "0";
				System.out.println("No se guardo la pelicula " + resultado);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al guardar " + e.getMessage());
		}
		return resultado;
	}

	@Override
	public String editar(Object obj) {
		// TODO Auto-generated method stub
		// Casteo
		pelicula = (Peliculas) obj;
		// Declarar variable para la conexion de BD
		Connection conexion;
		// Declarar variable para abrir la conexion
		PreparedStatement pst;
		// QUERY
		String query = "UPDATE PELICULAS_CINE SET NOMBRE=?,GENERO=?,DURACION=?,ACTOR=?,PRECIO=?,ESTATUS =? WHERE ID=?";
		// Declarar una variable para recibir una respuesta del servidor
		String resultado = null;
		try {
			// Cargar el controlador - Es el driver de conexion
			Class.forName(bd.getDriver());
			// Conexion a la base de datos
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			// Abir la conexion y mandar la sentencia de sql
			pst = conexion.prepareStatement(query);
			// Pasar los campos de nuestra tabla
			pst.setString(1, pelicula.getNombre());
			pst.setString(2, pelicula.getGenero());
			pst.setDouble(3, pelicula.getDuracion());
			pst.setString(4, pelicula.getActor());
			pst.setFloat(5, pelicula.getPrecio());
			pst.setInt(6, pelicula.getStatus());
			pst.setInt(7, pelicula.getId());
			// Declarar la variable para la validacion -- execuamos la query
			int editObj = pst.executeUpdate();

			if (editObj > 0) {
				resultado = "1";
				System.out.println("Se edito correctamente");
			} else {
				resultado = "0";
				System.out.println("No se edito correctamente");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al guardar " + e.getMessage());
		}

		return resultado;
	}

	@Override
	public String eliminar(Object obj) {

		pelicula = (Peliculas) obj;

		Connection conexion;

		PreparedStatement pst;

		String query = "DELETE FROM PELICULAS_CINE WHERE ID=" + pelicula.getId();

		String resultado = null;

		try {

			Class.forName(bd.getDriver());

			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());

			pst = conexion.prepareStatement(query);

			int rs = pst.executeUpdate();

			if (rs > 0) {
				resultado = "1";
				System.out.println("Se eliminó correctamente la película.");
			} else {
				resultado = "0";
				System.out.println("No se eliminó la película");
			}

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

		return resultado;
	}

	@Override
	public Object buscar(Object obj) {
		// TODO Auto-generated method stub

		pelicula = (Peliculas) obj;
		// Declarar variable para la conexion de BD
		Connection conexion;
		// Declarar variable para abrir la conexion
		PreparedStatement pst;
		// Query o sentencia sql para buscar
		String query = "SELECT * FROM PELICULAS_CINE WHERE ID=" + pelicula.getId();
		// Declarar la variable de memoria para la respuesta del servidor
		ResultSet rs = null;
		try {
			// Cargar el controlador - Es el driver de conexion
			Class.forName(bd.getDriver());
			// Conexion a la base de datos
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			// Abir la conexion y mandar la sentencia de sql
			pst = conexion.prepareStatement(query);
			// Ejecutar el query
			rs = pst.executeQuery();
			if (rs.next()) {
				pelicula = new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("GENERO"),
						rs.getDouble("DURACION"), rs.getString("ACTOR"), rs.getFloat("PRECIO"), rs.getInt("ESTATUS"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al guardar " + e.getMessage());
		}

		return pelicula;
	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		// Declarar la lista
		List<Object> listaPeli = new ArrayList<Object>();

		// Declarar variable para la conexion de BD
		Connection conexion;

		// Declarar variable para abrir la conexion
		PreparedStatement pst;

		// Query o sentencia sql
		String query = "SELECT * FROM PELICULAS_CINE";

		// Recibir la respuesta del servidor
		// Declarar la variable
		ResultSet rs = null;
		try {
			// Cargar el controlador - Es el driver de conexion
			Class.forName(bd.getDriver());
			// Conexion a la base de datos
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			// Abir la conexion y mandar la sentencia de sql
			pst = conexion.prepareStatement(query);
			// Ejecutar, apuntamos al objeto
			rs = pst.executeQuery();

			while (rs.next()) {
				listaPeli.add(new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("GENERO"),
						rs.getDouble("DURACION"), rs.getString("ACTOR"), rs.getFloat("PRECIO"), rs.getInt("ESTATUS")));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());
		}

		return listaPeli;
	}

}

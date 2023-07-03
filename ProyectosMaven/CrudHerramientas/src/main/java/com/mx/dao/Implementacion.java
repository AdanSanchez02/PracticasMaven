package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.conection.ConexionBD;
import com.mx.conection.Metodos;
import com.mx.entity.Herramientas;

public class Implementacion implements Metodos {

	ConexionBD bd = new ConexionBD();
	Herramientas herramienta;

	@Override
	public String guardar(Object obj) {

		herramienta = (Herramientas) obj;
		Connection conexion;
		PreparedStatement pst;
		String query = "INSERT INTO Herramientas VALUES(?,?,?,?,?,?,?)";
		String resultado = null;

		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			pst = conexion.prepareStatement(query);
			pst.setInt(1, herramienta.getId());
			pst.setString(2, herramienta.getTipo());
			pst.setString(3, herramienta.getNombre());
			pst.setString(4, herramienta.getTamano());
			pst.setDouble(5, herramienta.getPrecio());
			pst.setInt(6, herramienta.getCantidad());
			pst.setInt(7, herramienta.getExistencia());
			int insert = pst.executeUpdate();

			if (insert > 0) {
				resultado = "1";
				System.out.println("Se guardo correctamente " + resultado);

			} else {
				resultado = "0";
				System.out.println("No se guardo la pelicula " + resultado);

			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
		return resultado;
	}

	@Override
	public String editar(Object obj) {

		herramienta = (Herramientas) obj;
		Connection conexion;
		PreparedStatement pst;
		String query = "UPDATE Herramientas SET TIPO=?, NOMBRE=?, TAMANO=?, PRECIO=?, CANTIDAD=?, EXISTENCIA=? WHERE ID=?";
		String resultado = null;

		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			pst = conexion.prepareStatement(query);
			pst.setString(1, herramienta.getTipo());
			pst.setString(2, herramienta.getNombre());
			pst.setString(3, herramienta.getTamano());
			pst.setDouble(4, herramienta.getPrecio());
			pst.setInt(5, herramienta.getCantidad());
			pst.setInt(6, herramienta.getExistencia());
			pst.setInt(7, herramienta.getId());
			int editObj = pst.executeUpdate();

			if (editObj > 0) {
				resultado = "1";
				System.out.println("Se edito correctamente");
			} else {
				resultado = "0";
				System.out.println("No se edito correctamente");
			}

		} catch (Exception e) {
			System.out.println("Error al guardar " + e.getMessage());
		}
		return resultado;
	}

	@Override
	public String eliminar(Object obj) {

		herramienta = (Herramientas) obj;
		Connection conexion;
		PreparedStatement pst;
		String query = "DELETE FROM Herramientas WHERE ID=" + herramienta.getId();
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

		herramienta = (Herramientas) obj;
		Connection conexion;
		PreparedStatement pst;
		String query = "SELECT * FROM Herramientas WHERE ID=" + herramienta.getId();
		ResultSet rs = null;
		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs.next()) {
				herramienta = new Herramientas(rs.getInt("ID"), rs.getString("TIPO"), rs.getString("NOMBRE"),
						rs.getString("TAMANO"), rs.getDouble("PRECIO"), rs.getInt("CANTIDAD"), rs.getInt("EXISTENCIA"));
			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		return herramienta;
	}

	@Override
	public List<Object> listar() {
		List<Object> listHerr = new ArrayList<Object>();

		Connection conexion;
		PreparedStatement pst;
		String query = "SELECT * FROM Herramientas";
		ResultSet rs = null;

		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getPassword());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				listHerr.add(new Herramientas(rs.getInt("ID"), rs.getString("TIPO"), rs.getString("NOMBRE"),
						rs.getString("TAMANO"), rs.getDouble("PRECIO"), rs.getInt("CANTIDAD"),
						rs.getInt("EXISTENCIA")));

			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		return listHerr;
	}

}

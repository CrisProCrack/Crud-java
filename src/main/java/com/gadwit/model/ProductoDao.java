package com.gadwit.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
	private PreparedStatement statement;
	private Connection connection;
	private boolean estadoOperacion;
	
	private void guardar() {
		
	}
	
	private void editar() {

	}
	
	private void eliminar() {

	}

	/* Listar todos los productos */
	public List<Producto> obtenerProductos() throws SQLException {
		ResultSet resultSet = null;
		List<Producto> listaProductos = new ArrayList<>();
	
		String strSql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			strSql = "SELECT * FROM productos";
			statement = connection.prepareStatement(strSql);
			resultSet = statement.executeQuery(); // Remove strSql parameter here
			
			while (resultSet.next()) {
				Producto prod = new Producto();
				prod.setId(resultSet.getInt(1));
				prod.setNombre(resultSet.getString(2));
				prod.setCantidad(resultSet.getInt(3));
				prod.setPrecio(resultSet.getInt(4));
				prod.setFechaCrear(resultSet.getDate(5));
				prod.setFechaActualizar(resultSet.getDate(6));
				listaProductos.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return listaProductos;
	}

	private void obtenerProductos(int idProducto) {

	}
	
	private Connection obtenerConexion() throws SQLException{
		return Conexion.getConnection();
	}
}
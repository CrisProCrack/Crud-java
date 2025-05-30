package com.gadwit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gadwit.model.Producto;
import com.gadwit.model.ProductoDao;

@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductoController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Estas en el proyecto: ").append(request.getContextPath());
		System.out.println("Entraste en el controlador. Estoy en el método doGet");
		String opcion = request.getParameter("parametroOpcion");
		System.out.println("Estas enviando el valor:" + opcion);

		if (opcion.equals("listar")) {
			listar(request, response);
		} else if (opcion.equals("eliminar")) {
			response.getWriter().append("Usted dio clic en eliminar");
			System.out.println("Usted dio clic en eliminar");
		} else if (opcion.equals("editar")) {
			System.out.println("Usted dio clic en editar");
			response.getWriter().append("Usted dio clic en editar");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDao productoDao = new ProductoDao();
		List<Producto> lista = new ArrayList<>();

		try {
			lista = productoDao.obtenerProductos();

			/*
			 * for (Producto prod : lista) { System.out.println(prod.getNombre()); }
			 */

			/* Armemos el paquete que queremos enviar a la vista: listar.jsp */
			request.setAttribute("listaProductos", lista);
			RequestDispatcher rq = request.getRequestDispatcher("/views/listar.jsp");
			rq.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
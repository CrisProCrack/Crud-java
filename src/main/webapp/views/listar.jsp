<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
</head>
<body>
	<h1>Listado de productos</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Fecha Creación</th>
			<th>Fecha Actualización</th>
		</tr>
		<c:forEach var="producto" items="${listaProductos}">
			<tr>
				<td>
				<a href="/ProductoController?parametroOpcion=editar&id=<c:out value="${producto.id}"></c:out>">
				    <c:out value="${producto.id}"></c:out>
				</a>
				<td><c:out value="${producto.nombre}"></c:out></td>
				<td><c:out value="${producto.precio}"></c:out></td>
				<td><c:out value="${producto.cantidad}"></c:out></td>
				<td><c:out value="${producto.fechaCrear}"></c:out></td>
				<td><c:out value="${producto.fechaActualizar}"></c:out></td>
				<td>
				    <a href="/ProductoController?parametroOpcion=eliminar&id=<c:out value="${producto.id}"></c:out>">
				    Eliminar el <c:out value="${producto.id}"></c:out>
				    </a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
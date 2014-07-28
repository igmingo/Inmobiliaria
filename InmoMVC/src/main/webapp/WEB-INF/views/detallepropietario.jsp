<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle del producto</title>
</head>
<body>
	<table><tr><th>Detalle del Propietario ${propietario.idPropietario}</th></tr>
		<tr>
			<td>Nombre</td>
			<td>${propietario.nombre}</td>
		</tr>
		<tr>
			<td>DNI</td>
			<td>${propietario.dni}</td>
		</tr>
		<tr>
			<td>Ganancias mensuales</td>
		<td>${propGana} €</td>
		</tr>
		</table>
		<table><tr><th>Inmuebles en alquiler de ${propietario.nombre}</th></tr>
		<c:forEach items="${inmuebles }" var="inmueble">
			<tr>
				<td>${inmueble.direccion }</td>
				<td>${inmueble.precio }</td>
				<td>${inmueble.inquilino.nombre }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
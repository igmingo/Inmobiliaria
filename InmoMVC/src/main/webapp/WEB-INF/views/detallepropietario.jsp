<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Detalle Propietario</title>
</head>
<body>
	<div class="divPagDetalles">
		<table class="tblPagDetalles">
			<tr>
				<th colspan="2">Detalle del Propietario id ${propietario.idPropietario}</th>
			</tr>
			<tr>
				<td>Nombre</td>
				<td class="tdRight">${propietario.nombre}</td>
			</tr>
			<tr>
				<td>DNI</td>
				<td class="tdRight">${propietario.dni}</td>
			</tr>
			<tr>
				<td>Ganancias mensuales</td>
				<td class="tdRight">${propGana} €</td>
			</tr>
		</table>

		<table class="tblPagDetalles">
			<tr>
				<th colspan="2">Inmuebles en alquiler de ${propietario.nombre}</th>
			</tr>
			<c:forEach items="${inmuebles }" var="inmueble">
				<tr>
					<td>${inmueble.direccion }</td>
					<td class="tdRight">${inmueble.precio } €</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
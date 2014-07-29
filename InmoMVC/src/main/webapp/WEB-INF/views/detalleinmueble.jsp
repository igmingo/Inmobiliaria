<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Detalle Inmueble</title>
</head>
<body>
<div class="divPagDetalles">
	<table class="tblPagDetalles"><tr><th colspan="2">Detalle del Inmueble id ${inmueble.idInmueble}</th></tr>
		<tr>
			<td>Precio</td>
			<td class="tdRight">${inmueble.precio} €</td>
		</tr>
		<tr>
			<td>Dirección</td>
			<td class="tdRight">${inmueble.direccion}</td>
		</tr>
		<tr>
			<td>Propietario</td>
			<td class="tdRight">${inmueble.propietario.nombre}</td>
		</tr>
		<tr>
			<td>Inquilinio</td>
			<td class="tdRight">${inmueble.inquilino.nombre}</td>
		</tr>
	</table>
	</div>
</body>
</html>
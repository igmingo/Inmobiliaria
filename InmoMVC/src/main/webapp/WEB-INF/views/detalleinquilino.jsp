<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Detalle del Inquilino</title>
</head>
<body>
<div class="divPagDetalles">
	<table class="tblPagDetalles"><tr><th colspan="2">Detalle de Inquilino ${inquilino.idInquilino}</th></tr>
		<tr>
			<td>Nombre</td>
			<td class="tdRight">${inquilino.nombre}</td>
		</tr>
				<tr>
			<td>DNI</td>
			<td class="tdRight">${inquilino.dni}</td>
		</tr>
		<tr>
			<td>Edad</td>
			<td class="tdRight">${inquilino.edad} años</td>
		</tr>
		<tr>
			<td>Trabaja</td>
			<td class="tdRight">${inquilino.trabaja}</td>
		</tr>
	</table>
	<table class="tblPagDetalles"><tr><th colspan="2">Inmuebles alquilados por ${inquilino.nombre}</th></tr>
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
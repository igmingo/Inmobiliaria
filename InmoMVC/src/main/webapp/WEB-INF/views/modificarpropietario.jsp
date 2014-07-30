<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Modificar Propietario</title>
</head>
<body>
	<div class="divPagDetalles">
		<table class="tblPagDetalles">
			<tr>
				<th colspan="2">Datos del Propietario id
					${propietario.idPropietario}</th>
			</tr>
			<!-- es una etiqueta de Spring, en vez de un action es un commandName (un objeto que enviamos de vuelta) -->
			<form:form method="post" commandName="propietario">
				<!-- 	En vez de un name, se usa el path (la ruta de la propiedad de la Clase) (igual que en la clase) -->
				<form:hidden path="idPropietario" />
				<tr>
					<td>Nombre</td>
					<td class="tdRight"><form:textarea path="nombre" /></td>
				</tr>
				<tr>
					<td>DNI</td>
					<td class="tdRight"><form:input path="dni" /></td>
				</tr>
				<tr>
					<th colspan="2">Inmuebles en alquiler de ${propietario.nombre}</th>
				</tr>
				<tr>
					<td>Inmuebles</td>
					<td class="tdRight"><form:select path="idInmueble"
							multiple="true">
							<form:options items="${opciones_inmuebles}" />
						</form:select></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="Guardar" /></th>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>
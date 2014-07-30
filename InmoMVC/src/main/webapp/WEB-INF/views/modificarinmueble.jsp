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
<title>Modificar Inmueble</title>
</head>
<body>
	<div class="divPagDetalles">
		<table class="tblPagDetalles">
			<tr>
				<th colspan="2">Datos del Inmueble id ${inmueble.idInmueble}</th>
			</tr>
			<!-- es una etiqueta de Spring, en vez de un action es un commandName (un objeto que enviamos de vuelta) -->
			<form:form method="post" commandName="inmueble">
				<!-- 	En vez de un name, se usa el path (la ruta de la propiedad de la Clase) (igual que en la clase) -->
				<form:hidden path="idInmueble" />
				<tr>
					<td>Dirección</td>
					<td class="tdRight"><form:textarea path="direccion" /></td>
				</tr>
				<tr>
					<td>Precio</td>
					<td class="tdRight"><form:input path="precio" />
						<form:errors path="precio" /></td>
				</tr>
				<tr>
					<td>Propietario</td>
					<td class="tdRight"><form:select
							path="propietario.idPropietario">
							<form:options items="${opciones_propietarios}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Inquilino</td>
					<td class="tdRight"><form:select path="inquilino.idInquilino">
							<form:options items="${opciones_inquilinos}" />
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
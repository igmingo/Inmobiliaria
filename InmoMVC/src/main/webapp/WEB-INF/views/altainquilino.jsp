<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Alta de Inquilino</title>
</head>
<body>
	<div class="divPagDetalles">
		<table class="tblPagDetalles">
			<form:form method="post" commandName="inquilino">
				<tr>
					<th colspan="2">Alta de Inquilino</th>
				</tr>
				<tr>
					<td>Nombre</td>
					<td class="tdRight"><form:textarea path="nombre" /></td>
				</tr>
				<tr>
					<td>DNI</td>
					<td class="tdRight"><form:input path="dni" /> <form:errors
							path="dni" /></td>
				</tr>
				<tr>
					<td>Edad</td>
					<td class="tdRight"><form:input path="edad" /> <form:errors
							path="edad" /></td>
				</tr>
				<tr>
					<td>Trabaja</td>
					<td class="tdRight"><form:checkbox path="trabaja" /></td>
				</tr>
				<tr>
					<th colspan="2">Inmuebles alquilados por ${inquilino.nombre}</th>
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
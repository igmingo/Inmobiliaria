<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estadisticas de Inmuebles</title>
</head>
<body>
	<table>
		<tr>
			<th>Propietario con más inmuebles</th>
			<th></th>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><a href="propietario-${propmax.idPropietario}.html">${propmax.nombre }</a></td>
		</tr>
		<tr>
			<td>DNI</td>
			<td>${propmax.dni }</td>
		</tr>
		<tr>
			<td>Inmuebles</td>
			<td>${maxinmus }</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>Inmuebles en alquiler</td> -->
<!-- 			<td> -->
<!-- 				<ol> -->
<%-- 					<c:forEach items="${inmupropmax }" var="inmueble"> --%>
<%-- 						<li>${inmueble.direccion }</li> --%>
<%-- 					<tr>
			<td>DNI</td>
			<td>${propmax.dni }</td>
		</tr>		</c:forEach> --%>
<!-- 				</ol> -->
<!-- 			</td> -->
<!-- 		</tr> -->
	</table>
	<table>
		<tr>
			<th>Propietario con más ganancias</th>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><a href="propietario-${propmasgana.idPropietario}.html">${propmasgana.nombre }</a></td>
		</tr>
		<tr>
			<td>DNI</td>
			<td>${propmasgana.dni }</td>
		</tr>
		<tr>
			<td>Ganancia</td>
			<td>${masgana } €</td>
		</tr>
	</table>
</body>
</html>
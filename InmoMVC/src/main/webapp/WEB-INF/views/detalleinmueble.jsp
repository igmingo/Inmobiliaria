<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle del producto</title>
</head>
<body>
	<table><tr><th>Detalle de Inmueble</th></tr>
		<tr>
			<td>Nombre</td>
			<td>${inmueble.idInmueble}</td>
		</tr>
				<tr>
			<td>Precio</td>
			<td>${inmueble.precio}</td>
		</tr>
		<tr>
			<td>Dirección</td>
			<td>${inmueble.direccion}</td>
		</tr>
		<tr>
			<td>Propietario</td>
			<td>${inmueble.propietario.nombre}</td>
		</tr>
		<tr>
			<td>Inquilinio</td>
			<td>${inmueble.inquilino.nombre}</td>
		</tr>
	</table>
</body>
</html>
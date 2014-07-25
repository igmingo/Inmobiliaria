<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle del producto</title>
</head>
<body>
	<table><tr><th>Detalle de Inquilino ${inquilino.idInquilino}</th></tr>
		<tr>
			<td>Nombre</td>
			<td>${inquilino.nombre}</td>
		</tr>
				<tr>
			<td>DNI</td>
			<td>${inquilino.dni}</td>
		</tr>
		<tr>
			<td>Edad</td>
			<td>${inquilino.edad}</td>
		</tr>
		<tr>
			<td>Trabaja</td>
			<td>${inquilino.trabaja}</td>
		</tr>
	</table>
</body>
</html>
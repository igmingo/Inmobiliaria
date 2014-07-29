<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estadisticas de Inmuebles</title>
</head>
<body>
	<table><tr><th>Estadisticas de Inmuebles</th></tr>
		<tr>
			<td>Número de Inmuebles</td>
			<td>${ninmuebles }</td>
		</tr>
		<tr>
			<td>Precio Medio</td>
			<td>${media } €</td>
		</tr>
		<tr>
			<td>Precio Máximo</td>
			<td>${maximo } €</td>
		</tr>
		<tr>
			<td>Precio Mínimo</td>
			<td>${minimo } €</td>
		</tr>
	</table>
</body>
</html>
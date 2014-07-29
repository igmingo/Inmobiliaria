<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Estadisticas de Inmuebles</title>
</head>
<body>
	<div class="divPagDetalles">
		<table class="tblPagDetalles">
			<tr>
				<th colspan="2">Estadisticas de Inmuebles</th>
			</tr>
			<tr>
				<td>Número de Inmuebles</td>
				<td class="tdRight">${ninmuebles }</td>
			</tr>
			<tr>
				<td>Precio Medio</td>
				<td class="tdRight">${media }€</td>
			</tr>
			<tr>
				<td>Precio Máximo</td>
				<td class="tdRight">${maximo }€</td>
			</tr>
			<tr>
				<td>Precio Mínimo</td>
				<td class="tdRight">${minimo }€</td>
			</tr>
		</table>
	</div>
</body>
</html>
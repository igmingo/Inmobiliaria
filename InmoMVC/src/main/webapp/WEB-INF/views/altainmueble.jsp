<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Inmueble</title>
</head>
<body>

Datos del Inmueble<br/>
	<form:form method="post" commandName="inmueble">
	Dirección: <form:textarea path="direccion" /><br />
	Precio: <form:input path="precio" /><br />
	<form:errors path="precio"/>
	Propietario: <form:select path="propietario.idPropietario">
					<form:options items="${opciones_propietarios}" />
			   </form:select><br />
	Inquilino: <form:select path="inquilino.idInquilino">
					<form:options items="${opciones_inquilinos}" />
			   </form:select><br />
			<input type="submit" value="Guardar"/>		
	</form:form>
</body>
</html>
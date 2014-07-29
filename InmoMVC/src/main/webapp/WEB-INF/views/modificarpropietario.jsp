<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Propietario</title>
</head>
<body>
Datos del Propietario<br/>
<!-- es una etiqueta de Spring, en vez de un action es un commandName (un objeto que enviamos de vuelta) -->
	<form:form method="post" commandName="propietario">
<!-- 	En vez de un name, se usa el path (la ruta de la propiedad de la Clase) (igual que en la clase) -->
				<form:hidden path="idPropietario"/>
	Nombre: <form:textarea path="nombre" /><br />
	DNI: <form:input path="dni" /><br />
	<form:errors path="dni"/>
	Inmuebles: <form:select path="inmuebles" multiple="true" >
					<form:options items="${opciones_inmuebles}" />
			   </form:select><br />
			<input type="submit" value="Guardar"/>		
	</form:form>
</body>
</html>
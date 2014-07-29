<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Inmobiliaria Teide IV</title>
</head>

<body>
	<div id="container">
		<div class="header">
			<div id="divTitulo">
				<h1>Inmobiliaria Teide IV</h1>
			</div>
				<ul>
					<li class="opcion"><h1><a class="opcion" href="listadoinmuebles.html" title="INMUEBLES"><span class="icon-home"></span></a></h1></li>
					<li class="opcion"><h1><a class="opcion" href="listadopropietarios.html" title="PROPIETARIOS"><span class="icon-user2"></span></a></h1></li>
					<li class="opcion"><h1><a class="opcion" href="listadoinquilinos.html" title="INQUILINOS"><span class="icon-user"></span></a></h1></li>
				</ul>
		</div>

		<div id="HomeImage" class="divHomeImage">
			<img width=770px src='<c:url value="/resources/images/inmobiliaria.jpg" />' alt="Teide IV Inmobiliaria" />
		</div>

		<div class="divfooter">
			<h6>
				&copy; 2014, <a href="http://www.IgMingo.com">www.IgMingo.com</a>.
				Curso de Programador de Apliaciones Orientadas a Objetos
			</h6>
		</div>
	</div>
</body>
</html>

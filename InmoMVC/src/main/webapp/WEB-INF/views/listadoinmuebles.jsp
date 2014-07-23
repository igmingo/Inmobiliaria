<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' media="all" />
	<title>Listado de Inmuebles</title>
</head>

<body>
	<input type="text" id="txtBuscar" placeholder="Búsqueda de inmueble">
	<input type="button" id="btnBuscar" value="Buscar" onclick="buscar()"><span class="icon-search"></span>
 	<a id="btnBuscar" href="javascript:buscar()"><span class="icon-buscar"></span></a><br/>
<div id="divLista" class="CSSTable">
	<table id="tblDatos">
 	<thead><tr><th>idInmueble</th><th>Dirección</th><th>Precio</th><th>Acciones</th></tr></thead>
 	<tbody>
		<c:forEach items="${inmuebles }" var="inmueble">
			<tr>
				<td>${inmueble.idInmueble }</td>
				<td>${inmueble.direccion }</td>
				<td>${inmueble.precio } €</td>			
				<td>
				<a href="modificarProducto.html/${inmueble.idInmueble}"><span class="icon-pencil"></span></a>
				<a href="detalle-${inmueble.idInmueble}.html"><span class="icon-ver"></span></a>
				<a href="#" id="lnkDetalle" onclick="evento(${inmueble.idInmueble})"><span class="icon-eye"></span></a>
				<a href="#" id="lnkBorrar" onclick="borrar(${inmueble.idInmueble})"><span class="icon-remove"></span></a>
				</td>
			</tr>
		</c:forEach>
	</tbody></table>
</div>
<a id="btnAlta" href="altaInmueble.html">Alta de Inmueble</a>
<div class="TableDetalles" id="divDetalle">
</div>
</body>

<script type="text/javascript" src='<c:url value="/resources/js/jquery.js" />'></script>

<script type="text/javascript">

function borrar(id){precio
	var datos={idInmueble:id};
	var datosPasar=JSON.stringify(datos);
	$.ajax(
			"inmueble",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Inmueble borrado correctamente");
					//para actualizar el listado, hago una busqueda vacía
					$("#txtBuscar").text("");
					buscar();
					},
				error: function(res){
					alert(JSON.stringify(res));
					}
				}
			);
}


function buscar() {
	var tx=$("#txtBuscar").val();

	if(tx=="")
		tx="BusquedA_VaciA";

	var url="inmueble/buscar/"+tx;

	$.get(url, function (res){

		var tabla=$("#tblDatos");

		$("#tblDatos tbody tr").each(function(){
			$(this).remove();
		});
		
		//recorremos los datos devueltos con la búsqueda
		
		for(var i=0;i<res.length;i++){
			var h="";
			h+="<tr>";
			h+="<td>"+res[i].idInmueble+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+res[i].idInmueble+"'> Abrir Detalles </a>";
			h+="<a href='#' id='lnkDetalle' onclick='evento("+res[i].idInmueble+")'> Resumen Detalles </a>";
			h+="<a href='#' id='lnkBorrar' onclick='borrar("+res[i].idInmueble+")'> Borrar Inmueble </a></td>";
			h+="</tr>";
			tabla.append(h);
		}
		tabla.append(h);
	});
}

function evento(id){

	var url="inmueble/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<table><tr><th>Detalles del Inmueble</th><th>"+res.idInmueble+"</th></tr>";
		resultado+="<tr><td>Dirección:</td><td>"+res.direccion+"</td></tr>";
		resultado+="<tr><td>Precio:</td><td>"+res.precio+"</td></tr>";
		resultado+="<tr><td>Propietario:</td><td>"+res.propietario.nombre+"</td></tr>";
		resultado+="<tr><td>Inquilino:</td><td>"+res.inquilino.nombre+"</td></tr></table>";
		//$("#divDetalle") es el objeto, y le aplico el método html con el resultado
		$("#divDetalle").html(resultado);
		});
}
</script>	
</html>

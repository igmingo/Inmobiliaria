<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Listado de Inmuebles</title>
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

		<div id="Tareas" class="divTareas">
			<h2>Tareas</h2>
			<ul class="opciones">
				<li class="opcion"><a id="btnAlta" class="opcion"
					href="altaInmueble.html"><span class="icon-home"></span> Nuevo Inmueble</a></li>
				<li class="opcion"><a id="btnAlta" class="opcion"
					href="altaPropietario.html"><span class="icon-user2"></span> Nuevo Propietario</a></li>
				<li class="opcion"><a id="btnAlta" class="opcion"
					href="altaInquilino.html"><span class="icon-user"></span> Nuevo Inquilino</a></li>
			</ul>
		</div>

		<div class="divDetalles" id="divDetalles">
			<h2>Detalles</h2>
			<table id="tblDetalles">
				<thead>
					<tr>
						<th>Detalles</th>
						<th>Inmueble</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="divLista" class="divListado">
			<h2>Listado de Inmuebles</h2>
			<div class="divBusquedas">
					<input class="busqueda" type="text" id="txtBuscar" placeholder="Dirección inmueble" size="22">
					<a id="btnBuscar" href="javascript:buscar()"><span class="icon-search"></span></a>&nbsp;&nbsp;&nbsp;
					<input class="busqueda" type="text" id="txtEntre1" placeholder="min €"  size="5">-<input class="busqueda" type="text" id="txtEntre2" placeholder="max €" size="5">
					<a id="btnEntre" href="javascript:entre()"><span class="icon-search"></span></a>
			</div>
			<table id="tblDatos">
				<thead>
					<tr>
						<th>id</th>
						<th>Dirección</th>
						<th>Precio</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inmuebles }" var="inmueble">
						<tr>
							<td class="tdId">${inmueble.idInmueble }</td>
							<td>${inmueble.direccion }</td>
							<td class="tdPrecio" >${inmueble.precio }€</td>
							<td class="tdAcciones">
								<a href="#" id="lnkDetalle" onclick="evento(${inmueble.idInmueble})" title="Ver Detalles del Inmueble"><span class="icon-eye"></span></a>
								
								<a href="modificarInmueble-${inmueble.idInmueble}.html" title="Editar Inmueble"><span class="icon-pencil"></span></a>
													
								<a	href="detalle-${inmueble.idInmueble}.html" title="Abrir página de Detalles"><span class="icon-file"></span></a>
								
								<a href="#" id="lnkBorrar" onclick="borrar(${inmueble.idInmueble})" title="Eliminar Inmueble"><span class="icon-remove"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="divfooter">
			<h6>
				&copy; 2014, <a href="http://www.IgMingo.com">www.IgMingo.com</a>.
				Curso de Programador de Apliaciones Orientadas a Objetos
			</h6>
		</div>
	</div>
</body>

<script type="text/javascript"
	src='<c:url value="/resources/js/jquery.js" />'></script>

<script type="text/javascript">

function borrar(id){
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


function entre() {
	var tx1=$("#txtEntre1").val();
	var tx2=$("#txtEntre2").val();
	if(tx1=="")
		tx1="0";
	if(tx2=="")
		tx2="999999999";
	var url="inmueble/entre/" + tx1 + "-" + tx2;
	$.get(url, function (res){
		var tabla=$("#tblDatos");
		$("#tblDatos tbody tr").each(function(){
			$(this).remove();
		});	
		for(var i=0;i<res.length;i++){
			var h="";
			h+="<tr>";
			h+="<td class='tdId'>"+res[i].idInmueble+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td class='tdPrecio'>"+res[i].precio+"€</td>";
			h+="<td class='tdAcciones'>";
			h+="<a href='#' id='lnkDetalle' onclick='evento("+res[i].idInmueble+")' title='Ver Detalles del Inmueble'><span class='icon-eye'></span></a>";
			h+="<a href='modificarInmueble-"+res[i].idInmueble+ ".html' title='Editar Inmueble'><span class='icon-pencil'></span></a>";	
			h+="<a href='detalle-"+res[i].idInmueble+".html' title='Abrir página de Detalles'><span class='icon-file'></span></a>";
			h+="<a href='#' id='lnkBorrar' onclick='borrar("+res[i].idInmueble+")' title='Eliminar Inmueble'><span class='icon-remove'></span></a>";
			h+="</td>";
			tabla.append(h);
		}
	});
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
		for(var i=0;i<res.length;i++){
			var h="";
			h+="<tr>";
			h+="<td>"+res[i].idInmueble+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td class='tdPrecio'>"+res[i].precio+"€</td>";
			h+="<td class='tdAcciones'>";
			h+="<a href='#' id='lnkDetalle' onclick='evento("+res[i].idInmueble+")' title='Ver Detalles del Inmueble'><span class='icon-eye'></span></a>";
			h+="<a href='modificarInmueble-"+res[i].idInmueble+ ".html' title='Editar Inmueble'><span class='icon-pencil'></span></a>";	
			h+="<a href='detalle-"+res[i].idInmueble+".html' title='Abrir página de Detalles'><span class='icon-file'></span></a>";
			h+="<a href='#' id='lnkBorrar' onclick='borrar("+res[i].idInmueble+")' title='Eliminar Inmueble'><span class='icon-remove'></span></a>";
			h+="</td>";
			tabla.append(h);
		}
	});
}

function evento(id){

	var url="inmueble/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var tabla=$("#tblDetalles");

		$("#tblDetalles tbody tr").each(function(){
			$(this).remove();
		});

		var h="";
		h+="<tr><td>Dirección:</td><td>"+res.direccion+"</td></tr>";
		h+="<tr><td>Precio:</td><td>"+res.precio+"</td></tr>";
		h+="<tr><td>Propietario:</td><td>"+res.propietario.nombre+"</td></tr>";
		h+="<tr><td>Inquilino:</td><td>"+res.inquilino.nombre+"</td></tr>";
		tabla.append(h);

		});
}
</script>
</html>

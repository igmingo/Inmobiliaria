<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />' media="all" />
<title>Listado de Inquilinos</title>
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
			<ul class="opcion">
				<li class="opcion"><a class="opcion" href="altaInmueble.html"><span class="icon-home"></span> Nuevo Inmueble</a></li>
				<li class="opcion"><a class="opcion" href="altaPropietario.html"><span class="icon-user2"></span> Nuevo Propietario</a></li>
				<li class="opcion"><a class="opcion" href="altaInquilino.html"><span class="icon-user"></span> Nuevo Inquilino</a></li>
			</ul>
		</div>

		<div class="divDetalles" id="divDetalles">
			<h2>Detalles</h2>
			<table id="tblDetalles">
				<thead>
					<tr>
						<th>Detalles</th>
						<th>Inquilino</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="divLista" class="divListado">
			<h2>Listado de Inquilinos</h2>
			<div class="divBusquedas">
					<input class="busqueda" type="text" id="txtBuscar" placeholder="Nombre Inquilino" size="22">
					<a id="btnBuscar" href="javascript:buscar()"><span class="icon-search"></span></a>&nbsp;&nbsp;&nbsp;
					<input class="busqueda" type="text" id="txtDNI" placeholder="DNI con letra"  size="10">
					<a id="btnDNI" href="javascript:buscarDNI()"><span class="icon-search"></span></a>
			</div>
			<table id="tblDatos">
				<thead>
					<tr>
						<th>id</th>
						<th>Nombre</th>
						<th>DNI</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inquilinos }" var="inquilino">
						<tr>
							<td class="tdId">${inquilino.idInquilino }</td>
							<td>${inquilino.nombre }</td>
							<td class="tdDNI" >${inquilino.dni }</td>
							<td class="tdAcciones">
								<a href="#" id="lnkDetalle" onclick="evento(${inquilino.idInquilino})" title="Ver Detalles del Inquilino"><span class="icon-eye"></span></a>
								
								<a href="modificarInquilino-${inquilino.idInquilino}.html" title="Editar Inquilino"><span class="icon-pencil"></span></a>
													
								<a	href="inquilino-${inquilino.idInquilino}.html" title="Abrir página de Detalles"><span class="icon-file"></span></a>
								
								<a href="#" id="lnkBorrar" onclick="borrar(${inquilino.idInquilino})" title="Eliminar Inquilino"><span class="icon-remove"></span></a></td>
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
	var datos={idInquilino:id};
	var datosPasar=JSON.stringify(datos);
	$.ajax(
			"inquilino",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Inquilino borrado correctamente");
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

function buscarDNI() {
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="BusquedA_VaciA";
	var url="inquilino/dni/"+tx;
	$.get(url, function (res){
		var tabla=$("#tblDatos");
		$("#tblDatos tbody tr").each(function(){
			$(this).remove();
		});	
		for(var i=0;i<res.length;i++){
			var h="";
			h+="<tr>";
			h+="<td class='tdId'>"+res[i].idInquilino+"</td>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td class='tdDNI'>"+res[i].dni+"</td>";
			h+="<td class='tdAcciones'>";
			h+="<a href='#' id='lnkDetalle' onclick='evento("+res[i].idInquilino+")' title='Ver Detalles del Inquilino'><span class='icon-eye'></span></a>";
			h+="<a href='modificarInquilino-"+res[i].idInquilino+ ".html' title='Editar Inquilino'><span class='icon-pencil'></span></a>";	
			h+="<a href='inquilino-"+res[i].idInquilino+".html' title='Abrir página de Detalles'><span class='icon-file'></span></a>";
			h+="<a href='#' id='lnkBorrar' onclick='borrar("+res[i].idInquilino+")' title='Eliminar Inquilino'><span class='icon-remove'></span></a>";
			h+="</td>";
			tabla.append(h);
		}
	});
}

function buscar() {
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="BusquedA_VaciA";
	var url="inquilino/buscar/"+tx;
	$.get(url, function (res){
		var tabla=$("#tblDatos");
		$("#tblDatos tbody tr").each(function(){
			$(this).remove();
		});	
		for(var i=0;i<res.length;i++){
			var h="";
			h+="<tr>";
			h+="<td>"+res[i].idInquilino+"</td>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td class='tdDNI'>"+res[i].dni+"</td>";
			h+="<td class='tdAcciones'>";
			h+="<a href='#' id='lnkDetalle' onclick='evento("+res[i].idInquilino+")' title='Ver Detalles del Inquilino'><span class='icon-eye'></span></a>";
			h+="<a href='modificarInquilino-"+res[i].idInquilino+ ".html' title='Editar Inquilino'><span class='icon-pencil'></span></a>";	
			h+="<a href='inquilino-"+res[i].idInquilino+".html' title='Abrir página de Detalles'><span class='icon-file'></span></a>";
			h+="<a href='#' id='lnkBorrar' onclick='borrar("+res[i].idInquilino+")' title='Eliminar Inquilino'><span class='icon-remove'></span></a>";
			h+="</td>";
			tabla.append(h);
		}
	});
}

function evento(id){

	var url="inquilino/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var tabla=$("#tblDetalles");

		$("#tblDetalles tbody tr").each(function(){
			$(this).remove();
		});

		var h="";
		h+="<tr><td>Nombre:</td><td>"+res.nombre+"</td></tr>";
		h+="<tr><td>DNI:</td><td>"+res.dni+"</td></tr>";
		tabla.append(h);

		});
}
</script>
</html>

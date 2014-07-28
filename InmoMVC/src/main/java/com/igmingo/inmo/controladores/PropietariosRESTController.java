package com.igmingo.inmo.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="/propietario")
public class PropietariosRESTController {
	
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody Propietario propietario(@PathVariable int id) {
		
		Propietario p=daoPropietarios.get(Propietario.class, id);
		
		return p;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buscar/{texto}")
	public @ResponseBody List<Propietario> 
				buscar(@PathVariable String texto){
		if(texto.equals("BusquedA_VaciA"))
			texto="";
		Map<String, Object> params=new HashMap();
		params.put("textobuscado", "%"+texto+"%");
		List<Propietario> l=daoPropietarios.find("propietario.nombre", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/dni/{texto}")
	public @ResponseBody List<Propietario> 
				buscardni(@PathVariable String texto){
		if(texto.equals("BusquedA_VaciA"))
			texto="";
		Map<String, Object> params=new HashMap();
		params.put("dnibuscado", "%"+texto+"%");
		List<Propietario> l=daoPropietarios.find("propietario.dni", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Propietario propi){
		daoPropietarios.delete(propi);
		return "borrado";
	}
}

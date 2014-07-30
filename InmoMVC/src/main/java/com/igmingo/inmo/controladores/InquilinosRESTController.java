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

import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;

@Controller
@RequestMapping(value="/inquilino")
public class InquilinosRESTController {
	
	@Autowired
	RepositorioInquilinos daoInquilinos;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody Inquilino inquilino(@PathVariable int id) {
		
		Inquilino i=daoInquilinos.get2(Inquilino.class, id);
		
		return i;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buscar/{texto}")
	public @ResponseBody List<Inquilino> 
				buscar(@PathVariable String texto){
		if(texto.equals("BusquedA_VaciA"))
			texto="";
		Map<String, Object> params=new HashMap();
		params.put("textobuscado", "%"+texto+"%");
		List<Inquilino> l=daoInquilinos.find("inquilino.nombre", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/dni/{texto}")
	public @ResponseBody List<Inquilino> 
				buscardni(@PathVariable String texto){
		if(texto.equals("BusquedA_VaciA"))
			texto="";
		Map<String, Object> params=new HashMap();
		params.put("dnibuscado", "%"+texto+"%");
		List<Inquilino> l=daoInquilinos.find("inquilino.dni", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino inqui){
		daoInquilinos.delete(inqui);
		return "borrado";
	}
}

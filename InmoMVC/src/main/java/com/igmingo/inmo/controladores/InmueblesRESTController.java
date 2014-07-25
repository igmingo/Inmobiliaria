package com.igmingo.inmo.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;

@Controller
@RequestMapping(value="/inmueble")
public class InmueblesRESTController {
	
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody Inmueble inmueble(@PathVariable int id) {
		
		Inmueble i=daoInmuebles.get(Inmueble.class, id);
		
		return i;
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<Inmueble> 
				buscar(@PathVariable String texto){
		if(texto.equals("BusquedA_VaciA"))
			texto="";
		Map<String, Object> params=new HashMap();
		params.put("textobuscado", "%"+texto+"%");
		List<Inmueble> l=daoInmuebles.find("inmueble.direccion", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/menosde/{valor}")
	public @ResponseBody List<Inmueble> 
			menorque(@PathVariable Double valor){
		Map<String, Object> params=new HashMap();
		params.put("valorbuscado", valor);
		List<Inmueble> l=daoInmuebles.find("inmueble.menorque", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/masde/{valor}")
	public @ResponseBody List<Inmueble> 
			mayorque(@PathVariable Double valor){
		Map<String, Object> params=new HashMap();
		params.put("valorbuscado", valor);
		List<Inmueble> l=daoInmuebles.find("inmueble.mayorque", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/entre/{valor1}-{valor2}")
	public @ResponseBody List<Inmueble> 
			entre(@PathVariable Double valor1, @PathVariable Double valor2){
		Map<String, Object> params=new HashMap();
		params.put("minvalorbuscado", valor1);
		params.put("maxvalorbuscado", valor2);
		
		
		List<Inmueble> l=daoInmuebles.find("inmueble.entre", params);
		return l;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inmueble inmu){
		daoInmuebles.delete(inmu);
		return "borrado";
	}
}

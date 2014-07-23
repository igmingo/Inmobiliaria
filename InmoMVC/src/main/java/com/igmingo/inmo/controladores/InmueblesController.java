package com.igmingo.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;

@Controller
public class InmueblesController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(value="/listado.html")
	public String listado(Model modelo) {
		List<Inmueble> li=daoInmuebles.get(Inmueble.class);
		modelo.addAttribute("inmuebles", li);

		return "listadoinmuebles";
	}
	
	// Es recomendable por el SEO, poner una URL seo
	@RequestMapping(value="detalle-{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		Inmueble p=daoInmuebles.get(Inmueble.class, id);
		modelo.addAttribute("inmueble", p);
		return "detalleinmueble";
	}	
	
}

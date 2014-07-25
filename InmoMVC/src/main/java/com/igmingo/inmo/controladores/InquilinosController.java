package com.igmingo.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;

@Controller
public class InquilinosController {

	@Autowired
	RepositorioInquilinos daoInquilinos;
	
	@RequestMapping(value="listadoinquilinos.html")
	public String listado(Model modelo) {
		List<Inquilino> li=daoInquilinos.get(Inquilino.class);
		modelo.addAttribute("inquilinos", li);

		return "listadoinquilinos";
	}
	
	// Es recomendable por el SEO, poner una URL seo
	@RequestMapping(value="inquilino-{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		Inquilino p=daoInquilinos.get(Inquilino.class, id);
		modelo.addAttribute("inquilino", p);
		return "detalleinquilino";
	}	
	
}

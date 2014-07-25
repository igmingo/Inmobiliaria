package com.igmingo.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class PropietariosController {

	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(value="listadopropietarios.html")
	public String listado(Model modelo) {
		List<Propietario> li=daoPropietarios.get(Propietario.class);
		modelo.addAttribute("propietarios", li);

		return "listadopropietarios";
	}
	
	// Es recomendable por el SEO, poner una URL seo
	@RequestMapping(value="propietario-{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		Propietario p=daoPropietarios.get(Propietario.class, id);
		modelo.addAttribute("propietario", p);
		return "detallepropietario";
	}	
	
}

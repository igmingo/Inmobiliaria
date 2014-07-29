package com.igmingo.inmo.controladores;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class PropietariosController {

	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@Autowired
	RepositorioInmuebles daoInmuebles;

	@Autowired
	RepositorioInquilinos daoInquilinos;
	
	@RequestMapping(value="listadopropietarios.html")
	public String listado(Model modelo) {
		List<Propietario> li=daoPropietarios.get(Propietario.class);
		modelo.addAttribute("propietarios", li);
		return "listadopropietarios";
	}
	
	@RequestMapping(value="gananciaspropietarios.html")
	public String ganancias(Model modelo) {
		List<Propietario> li=daoPropietarios.get(Propietario.class);
		
		Map<Integer, String> linmu = daoPropietarios.getGanancias();
		modelo.addAttribute("ganancias_propietarios", linmu);

		return "gananciaspropietarios";
	}
	
	// Es recomendable por el SEO, poner una URL seo
	@RequestMapping(value="propietariocorto-{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		Propietario p=daoPropietarios.get(Propietario.class, id);
		Set<Inmueble> inmus = p.getInmuebles();		
				
		modelo.addAttribute("propietario", p);
		modelo.addAttribute("inmuebles", inmus);
		return "detallepropietario";
	}
	
	// Es recomendable por el SEO, poner una URL seo
	@RequestMapping(value="propietario-{id}.html")
	public String gana(Model modelo,@PathVariable int id){
		Propietario p=daoPropietarios.get(Propietario.class, id);
		Set<Inmueble> inmus = p.getInmuebles();
		
		double propGana = 0;
		Iterator<Inmueble> itListInmu=p.getInmuebles().iterator();
		while (itListInmu.hasNext()) {
			Inmueble propiInmu = (Inmueble) itListInmu.next();
			//si el inmueble del propietario tiene inquilino, entonces está alquilado y gana
			if (propiInmu.getInquilino()!=null) {
				System.out.println(propiInmu.getDireccion() + " tiene inquilino y paga " + propiInmu.getPrecio() + "€.");
				propGana+=propiInmu.getPrecio();
			}
		}
		
		modelo.addAttribute("propGana", propGana);
		modelo.addAttribute("propietario", p);
		modelo.addAttribute("inmuebles", inmus);
		return "detallepropietario";
	}	
}

package com.igmingo.inmo.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.viewfoms.InmuebleViewForm;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class InmuebleModificarController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioInquilinos daoInquilinos;
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(value = "/modificarInmueble-{id}.html", method = RequestMethod.GET)
	public String modificar(ModelMap modelo, @PathVariable int id) {

		Inmueble inmu = daoInmuebles.get(Inmueble.class, id);
		InmuebleViewForm iv = new InmuebleViewForm();
		iv.fromInmueble(inmu);
		modelo.addAttribute("inmueble", iv);
		
		Map<Integer, String> linqui = daoInquilinos.getMapaOptions();
		modelo.addAttribute("opciones_inquilinos", linqui);
		
		Map<Integer, String> lpropi = daoPropietarios.getMapaOptions();
		modelo.addAttribute("opciones_propietarios", lpropi);

		return "modificarinmueble";
	}
	
	@RequestMapping(value = "/modificarInmueble-{id}.html", method = RequestMethod.POST)
	public String doModificar(
			@ModelAttribute("inmueble") InmuebleViewForm inmueble,
			BindingResult resultado, HttpServletRequest request) {
		if (resultado.hasErrors()) {
			Map<Integer, String> linqui = daoInquilinos.getMapaOptions();
			request.setAttribute("opciones_inquilinos", linqui);
			
			Map<Integer, String> lpropi = daoPropietarios.getMapaOptions();
			request.setAttribute("opciones_propietarios", lpropi);
						
			return "modificarinmueble";
		}
		daoInmuebles.update(inmueble.getInmueble());
		return "redirect:/listado.html";
	}
	
}

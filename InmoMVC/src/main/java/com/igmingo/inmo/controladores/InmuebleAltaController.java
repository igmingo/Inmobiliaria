package com.igmingo.inmo.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;
import com.igmingo.inmo.modelo.viewfoms.InmuebleViewForm;

@Controller
@RequestMapping(value = "/altaInmueble.html")
public class InmuebleAltaController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioInquilinos daoInquilinos;
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(method = RequestMethod.GET)
	public String alta(ModelMap modelo) {
		InmuebleViewForm vistainmueble = new InmuebleViewForm();
		modelo.addAttribute("inmueble", vistainmueble);
		Map<Integer, String> lpropi = daoPropietarios.getMapaOptions();
		Map<Integer, String> linqui = daoInquilinos.getMapaOptions();

		modelo.addAttribute("opciones_propietarios", lpropi);
		modelo.addAttribute("opciones_inquilinos", linqui);
		return "altainmueble";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doAlta(@ModelAttribute("inmueble") InmuebleViewForm vistainmueble,
			BindingResult resultado, HttpServletRequest request) {
		
		if (resultado.hasErrors()) {
			Map<Integer, String> linqui = daoInquilinos.getMapaOptions();
			request.setAttribute("opciones_inquilinos", linqui);
			
			Map<Integer, String> lpropi = daoPropietarios.getMapaOptions();
			request.setAttribute("opciones_propietarios", lpropi);
						
			return "altainmueble";
		}
		daoInmuebles.add(vistainmueble.getInmueble());
		return "redirect:/listadoinmuebles.html";
	}
	
}

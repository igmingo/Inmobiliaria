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

import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.modelo.viewfoms.InquilinoViewForm;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;

@Controller
public class InquilinoModificarController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioInquilinos daoInquilinos;
	
	@RequestMapping(value = "/modificarInquilino-{id}.html", method = RequestMethod.GET)
	public String modificar(ModelMap modelo, @PathVariable int id) {

		Inquilino inqui = daoInquilinos.get(Inquilino.class, id);
		InquilinoViewForm pv = new InquilinoViewForm();
		pv.fromInquilino(inqui);
		modelo.addAttribute("inquilino", pv);
		
		Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
		modelo.addAttribute("opciones_inmuebles", linmu);

		return "modificarinquilino";
	}
	
	@RequestMapping(value = "/modificarInquilino-{id}.html", method = RequestMethod.POST)
	public String doModificar(
			@ModelAttribute("inquilino") InquilinoViewForm inquilino,
			BindingResult resultado, HttpServletRequest request) {
		if (resultado.hasErrors()) {
			Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
			request.setAttribute("opciones_inmuebles", linmu);
						
			return "modificarinquilino";
		}
		daoInquilinos.update(inquilino.getInquilino());
		return "redirect:/listadoinquilinos.html";
	}	
}

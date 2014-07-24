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
import com.igmingo.inmo.modelo.viewfoms.InquilinoViewForm;

@Controller
@RequestMapping(value = "/altaInquilino.html")
public class InquilinoAltaController {
	
	@Autowired
	RepositorioInquilinos daoInquilinos;	
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(method = RequestMethod.GET)
	public String alta(ModelMap modelo) {
		InquilinoViewForm vistainqui = new InquilinoViewForm();
		modelo.addAttribute("inquilino", vistainqui);
		Map<Integer, String> linmu = daoInmuebles.getMapaOptions();

		modelo.addAttribute("opciones_inmuebles", linmu);
		return "altainquilino";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doAlta(@ModelAttribute("inquilino") InquilinoViewForm vistainqui,
			BindingResult resultado, HttpServletRequest request) {
		
		if (resultado.hasErrors()) {
			
			Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
			request.setAttribute("opciones_inmuebles", linmu);
						
			return "altainquilino";
		}
		daoInquilinos.add(vistainqui.getInquilino());
		return "redirect:/listado.html";
	}
	
}

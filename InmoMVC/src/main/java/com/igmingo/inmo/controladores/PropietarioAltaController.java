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
import com.igmingo.inmo.repositorios.RepositorioPropietarios;
import com.igmingo.inmo.modelo.viewfoms.PropietarioViewForm;

@Controller
@RequestMapping(value = "/altaPropietario.html")
public class PropietarioAltaController {
	
	@Autowired
	RepositorioPropietarios daoPropietarios;	
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(method = RequestMethod.GET)
	public String alta(ModelMap modelo) {
		PropietarioViewForm vistapropi = new PropietarioViewForm();
		modelo.addAttribute("propietario", vistapropi);
		Map<Integer, String> linmu = daoInmuebles.getMapaOptions();

		modelo.addAttribute("opciones_inmuebles", linmu);
		return "altapropietario";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doAlta(@ModelAttribute("propietario") PropietarioViewForm vistapropi,
			BindingResult resultado, HttpServletRequest request) {
		
		if (resultado.hasErrors()) {
			
			Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
			request.setAttribute("opciones_inmuebles", linmu);
						
			return "altapropietario";
		}
		daoPropietarios.add(vistapropi.getPropietario());
		return "redirect:/listado.html";
	}
	
}

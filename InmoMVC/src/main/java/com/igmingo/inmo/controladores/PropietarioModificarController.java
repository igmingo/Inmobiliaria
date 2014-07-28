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

import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.modelo.viewfoms.PropietarioViewForm;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class PropietarioModificarController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(value = "/modificarPropietario-{id}.html", method = RequestMethod.GET)
	public String modificar(ModelMap modelo, @PathVariable int id) {

		Propietario propi = daoPropietarios.get(Propietario.class, id);
		PropietarioViewForm pv = new PropietarioViewForm();
		pv.fromPropietario(propi);
		modelo.addAttribute("propietario", pv);
		
		Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
		modelo.addAttribute("opciones_inmuebles", linmu);

		return "modificarpropietario";
	}
	
	@RequestMapping(value = "/modificarPropietario-{id}.html", method = RequestMethod.POST)
	public String doModificar(
			@ModelAttribute("propietario") PropietarioViewForm propietario,
			BindingResult resultado, HttpServletRequest request) {
		if (resultado.hasErrors()) {
			Map<Integer, String> linmu = daoInmuebles.getMapaOptions();
			request.setAttribute("opciones_inmuebles", linmu);
						
			return "modificarpropietario";
		}
		daoPropietarios.update(propietario.getPropietario());
		return "redirect:/listadopropietarios.html";
	}
	
}

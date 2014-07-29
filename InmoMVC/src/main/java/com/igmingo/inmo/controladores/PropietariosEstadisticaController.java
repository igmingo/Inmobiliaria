package com.igmingo.inmo.controladores;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class PropietariosEstadisticaController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@Autowired
	RepositorioPropietarios daoPropietarios;
		
	@RequestMapping(value="estadisticapropietarios.html")
	public String estadisticas(Model modelo) {
		
		List<Propietario> lProp=daoPropietarios.get(Propietario.class);
		
		int MaxInmus = 0;
		double MasGana = 0;
		
		Propietario propiMax = new Propietario();
		Propietario propiMasGana = new Propietario();
		
		Iterator<Propietario> itMaxInmu=lProp.iterator();
		while (itMaxInmu.hasNext()) {
			Propietario propi = daoPropietarios.get(Propietario.class,itMaxInmu.next().getIdPropietario());

			Set<Inmueble> inPropGanan = propi.getInmuebles();
			int nInmuebles = inPropGanan.size();
		
			double propGana = 0;
			
			Iterator<Inmueble> itListInmu=inPropGanan.iterator();
			while (itListInmu.hasNext()) {
				Inmueble propiInmu = (Inmueble) itListInmu.next();
				if (propiInmu.getInquilino()!=null) {
					System.out.println(propiInmu.getDireccion() + " está alquilado, y gana " + propiInmu.getPrecio() + "€.");
					propGana+=propiInmu.getPrecio();
				}
			}
			
			if (MasGana<propGana) {
				MasGana=propGana;
				propiMasGana = propi;
			}
			
			if (MaxInmus<nInmuebles) {
				MaxInmus=nInmuebles;
				propiMax = propi;
			}
			
		}
		System.out.println(propiMax.getNombre()  + " tiene "+ MaxInmus + " inmuebles");
		modelo.addAttribute("maxinmus", MaxInmus);
		modelo.addAttribute("propmax", propiMax);
		
		Set<Inmueble> inmus = propiMax.getInmuebles();	
		modelo.addAttribute("inmupropmax", inmus);
		
		modelo.addAttribute("masgana", MasGana);
		modelo.addAttribute("propmasgana", propiMasGana);
		
		return "estadisticaprop";
	}
}

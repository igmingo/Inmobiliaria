package com.igmingo.inmo.controladores;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;

@Controller
public class InmueblesEstadisticasController {
	
	@Autowired
	RepositorioInmuebles daoInmuebles;
		
	@RequestMapping(value="estadisticainmuebles.html")
	public String estadisticas(Model modelo) {
		
		List<Inmueble> linmu=daoInmuebles.get(Inmueble.class);
		double suma = 0;
		double maximo = 0;
		double minimo = 999999;
		Iterator<Inmueble> itinmu=linmu.iterator();
		while (itinmu.hasNext()) {
			Inmueble inmu = (Inmueble) itinmu.next();
			suma += inmu.getPrecio();
			if (maximo<inmu.getPrecio()) {
				maximo=inmu.getPrecio();
			}
			if (minimo>inmu.getPrecio()) {
				minimo=inmu.getPrecio();
			}
		}
		double media = suma/linmu.size();
		
		modelo.addAttribute("ninmuebles", linmu.size());
		modelo.addAttribute("media", String.format("%.2f", media));
		modelo.addAttribute("maximo", String.format("%.2f", maximo));
		modelo.addAttribute("minimo", String.format("%.2f", minimo));
		return "estadisticainmuebles";
	}
}

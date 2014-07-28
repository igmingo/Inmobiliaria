package com.igmingo.inmo.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;
import com.igmingo.inmo.repositorios.RepositorioPropietarios;

@Controller
public class EstadisticasController {
	
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@Autowired
	RepositorioInquilinos daoInquilinos;
	
	@RequestMapping(value="/estadisticas.html")
	public String estadisticas(Model modelo) {
			
		List<Propietario> lProp=daoPropietarios.get(Propietario.class);
		
		//obtengo el numero maximo de inmuebles por propietario
		int MaxInmus = 0;
		Iterator<Propietario> itMaxInmu=lProp.iterator();	
		while (itMaxInmu.hasNext()) {
			Propietario propi = (Propietario) itMaxInmu.next();
			propi.getInmuebles().size();
			if (MaxInmus<propi.getInmuebles().size()) {
				MaxInmus=propi.getInmuebles().size();	
			}
		}
		System.out.println("El que tiene más inmuebles, tiene " + MaxInmus + " y son: ");
		
		//tengo la lista de propietarios
		List<Propietario> lpMasInmuS = new ArrayList<Propietario>();	
		Iterator<Propietario> itListProp=lProp.iterator();	
		while (itListProp.hasNext()) {
			Propietario propi = (Propietario) itListProp.next();
			//comprueba si el propietario tiene el nº de inmuebles máximo
			if (propi.getInmuebles().size()>=MaxInmus) {
				lpMasInmuS.add(propi);
				System.out.print(propi.getNombre());
			}
			//vemos lo que gana el propietario
			double propGana = 0;
			//cogemos todos los inmuebles del propietario
			Iterator<Inmueble> itListInmu=propi.getInmuebles().iterator();
			while (itListProp.hasNext()) {
				Inmueble propiInmu = (Inmueble) itListInmu.next();
				//si el inmueble del propietario tiene inquilino, entonces está alquilado y gana
				if (propiInmu.getInquilino()!=null) {
					propGana+=propiInmu.getPrecio();
				}
			}
			System.out.println(propi.getNombre() + " gana " + propGana);
		}

		
		
		
		List<Inmueble> linmu=daoInmuebles.get(Inmueble.class);
		
		//obtengo el maximo precio
		double suma = 0;
		double maximo = 0;
		
		Iterator<Inmueble> itinmu=linmu.iterator();
		while (itinmu.hasNext()) {
			Inmueble inmu = (Inmueble) itinmu.next();
			suma += inmu.getPrecio();
			if (maximo<inmu.getPrecio()) {
				maximo=inmu.getPrecio();
			}
		}
		//obtengo la media precio
		double media = suma/linmu.size();
		System.out.println("La media de los inmuebles es " + media);
		System.out.println("El maximo precio de un inmueble es " + maximo);
		
		//El propietario o propietarios que ganan más
//		Map<Propietario,String> mapaPropietarios = new HashMap<Propietario,String>();
		
		return "estadisticas";
	}
}

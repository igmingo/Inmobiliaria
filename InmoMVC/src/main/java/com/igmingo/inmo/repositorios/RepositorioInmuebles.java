package com.igmingo.inmo.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Inquilino;

public class RepositorioInmuebles extends Repositorio<Inmueble>{
	
	@Override
	public Inmueble get(Class<Inmueble> tipo, int id) {
		Inmueble i=super.get(tipo, id);
		
		Hibernate.initialize(i.getInquilino());
		Hibernate.initialize(i.getPropietario());
		
		return i;			
	}
	
	public Map<Integer, String> getMapaOptions(){
		List<Inmueble> l=get(Inmueble.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Inmueble inmueble : l) {		
			mapa.put(inmueble.getIdInmueble(), inmueble.getDireccion());
		}
		return mapa;
	}

}

package com.igmingo.inmo.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import com.igmingo.inmo.modelo.Propietario;

public class RepositorioPropietarios extends Repositorio<Propietario>{
	
	@Override
	public Propietario get(Class<Propietario> tipo, int id) {
		Propietario p=super.get(tipo, id);
		Hibernate.initialize(p.getInmuebles());
		return p;			
	}
		
	public Map<Integer, String> getMapaOptions(){
		List<Propietario> l=get(Propietario.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
//		mapa.put(null, "Sin Propietario");
		for (Propietario prop : l) {
			mapa.put(prop.getIdPropietario(),prop.getNombre());
		}
		return mapa;
	}
	
	public Map<Integer, String> getGanancias(){
		List<Propietario> l=get(Propietario.class);

		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Propietario prop : l) {
			Hibernate.initialize(prop.getInmuebles());
			mapa.put(prop.getIdPropietario(),prop.getNombre());
		}
		return mapa;
	}
	
}

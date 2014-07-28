package com.igmingo.inmo.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;

import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.modelo.Propietario;

public class RepositorioInquilinos extends Repositorio<Inquilino>{
	
	@Override
	public Inquilino get(Class<Inquilino> tipo, int id) {
		Inquilino inqui=super.get(tipo, id);
		Hibernate.initialize(inqui.getInmuebles());
		return inqui;			
	}
	
	public Map<Integer, String> getMapaOptions(){
		List<Inquilino> l=get(Inquilino.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		mapa.put(0, "Sin Inquilino");
		for (Inquilino inqui : l) {		
			mapa.put(inqui.getIdInquilino(), inqui.getNombre());
		}
		return mapa;
	}

}

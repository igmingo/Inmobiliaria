package com.igmingo.inmo.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.inmo.modelo.Propietario;

public class RepositorioPropietarios extends Repositorio<Propietario>{
	
	public Map<Integer, String> getMapaOptions(){
		List<Propietario> l=get(Propietario.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Propietario prop : l) {
			
			mapa.put(prop.getIdPropietario(),prop.getNombre());
		}
		return mapa;
	}
}

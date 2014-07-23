package com.igmingo.inmo.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.inmo.modelo.Inquilino;

public class RepositorioInquilinos extends Repositorio<Inquilino>{
	
	public Map<Integer, String> getMapaOptions(){
		List<Inquilino> l=get(Inquilino.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Inquilino inqui : l) {		
			mapa.put(inqui.getIdInquilino(), inqui.getNombre());
		}
		return mapa;
	}

}

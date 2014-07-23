package com.igmingo.inmo.repositorios;

import org.hibernate.Hibernate;

import com.igmingo.inmo.modelo.Inmueble;

public class RepositorioInmuebles extends Repositorio<Inmueble>{
	
	@Override
	public Inmueble get(Class<Inmueble> tipo, int id) {
		Inmueble i=super.get(tipo, id);
		
		Hibernate.initialize(i.getInquilino());
		Hibernate.initialize(i.getPropietario());
		
		return i;			
	}

}

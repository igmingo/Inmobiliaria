package com.igmingo.inmo.modelo.viewfoms;


import java.util.HashSet;
import java.util.Set;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Propietario;

public class PropietarioViewForm {

    private Integer idPropietario;
    private String nombre;
    private String dni;
    private Set<Inmueble> inmuebles = new HashSet<Inmueble>(0);
    private Integer[] idInmueble;

	public PropietarioViewForm(Integer idPropietario, String nombre,
			String dni, Set<Inmueble> inmuebles, Integer[] idInmueble) {
		super();
		this.idPropietario = idPropietario;
		this.nombre = nombre;
		this.dni = dni;
		this.inmuebles = inmuebles;
		this.idInmueble = idInmueble;
	}

	public PropietarioViewForm() {
		super();
	}

	public Propietario getPropietario() {
		Propietario propi=new Propietario();
		propi.setIdPropietario(idPropietario);
		propi.setNombre(nombre);
		propi.setDni(dni);	
		propi.setInmuebles(inmuebles);
				
		Set<Inmueble> s=new HashSet<Inmueble>();
		for (Integer inmueble : idInmueble) {
			Inmueble i=new Inmueble();
			i.setIdInmueble(inmueble);
			s.add(i);
		}
		propi.setInmuebles(s);
		
		return propi;
	}
	
	public void fromPropietario(Propietario propi) {
		setIdPropietario(propi.getIdPropietario());
		setNombre(propi.getNombre());
		setDni(propi.getDni());
		setInmuebles(propi.getInmuebles());
		
		idInmueble=new Integer[propi.getInmuebles().size()];
		int i=0;
		for (Inmueble inmueble : propi.getInmuebles()) {
			idInmueble[i++]=inmueble.getIdInmueble();
		}		
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(Set<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Integer[] getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Integer[] idInmueble) {
		this.idInmueble = idInmueble;
	}
	
}

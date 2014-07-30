package com.igmingo.inmo.modelo.viewfoms;


import java.util.HashSet;
import java.util.Set;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Propietario;

public class PropietarioViewForm {

    private Integer idPropietario;
    private String nombre;
    private String dni;
    private Integer[] idInmueble;

	public PropietarioViewForm(Integer idPropietario, String nombre,
			String dni, Integer[] idInmueble) {
		super();
		this.idPropietario = idPropietario;
		this.nombre = nombre;
		this.dni = dni;
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

	public Integer[] getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Integer[] idInmueble) {
		this.idInmueble = idInmueble;
	}
	
}

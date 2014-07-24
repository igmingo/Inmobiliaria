package com.igmingo.inmo.modelo.viewfoms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.modelo.Propietario;
import com.igmingo.inmo.repositorios.RepositorioInmuebles;
import com.igmingo.inmo.repositorios.RepositorioInquilinos;

public class InquilinoViewForm {

    private Integer idInquilino;
    private String dni;
    private String nombre;
    private int edad;
    private Boolean trabaja;
    private Set<Inmueble> inmuebles = new HashSet<Inmueble>(0);

	public InquilinoViewForm() {
		super();
	}

	public InquilinoViewForm(Integer idInquilino, String dni, String nombre,
			int edad, Boolean trabaja, Set<Inmueble> inmuebles) {
		super();
		this.idInquilino = idInquilino;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.trabaja = trabaja;
		this.inmuebles = inmuebles;
	}

	public Inquilino getInquilino() {
		Inquilino inqui=new Inquilino();
		inqui.setIdInquilino(idInquilino);
		inqui.setNombre(nombre);
		inqui.setDni(dni);
		inqui.setEdad(edad);	
		inqui.setTrabaja(trabaja);
		inqui.setInmuebles(inmuebles);
		return inqui;
	}
	
	public void fromInquilino(Inquilino inqui) {
		setIdInquilino(inqui.getIdInquilino());	
		setNombre(inqui.getNombre());
		setDni(inqui.getDni());
		setEdad(inqui.getEdad());
		setTrabaja(inqui.getTrabaja());
		setInmuebles(inqui.getInmuebles());
	}

	public Integer getIdInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Boolean getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(Boolean trabaja) {
		this.trabaja = trabaja;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(Set<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
}

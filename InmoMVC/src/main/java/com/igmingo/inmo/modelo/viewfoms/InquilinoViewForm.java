package com.igmingo.inmo.modelo.viewfoms;

import java.util.HashSet;
import java.util.Set;
import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Inquilino;

public class InquilinoViewForm {

    private Integer idInquilino;
    private String dni;
    private String nombre;
    private int edad;
    private Boolean trabaja;
    private Integer[] idInmueble;

	public InquilinoViewForm() {
		super();
	}

	public InquilinoViewForm(Integer idInquilino, String dni, String nombre,
			int edad, Boolean trabaja, Integer[] idInmueble) {
		super();
		this.idInquilino = idInquilino;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.trabaja = trabaja;
		this.idInmueble = idInmueble;
	}

	public Inquilino getInquilino() {
		Inquilino inqui=new Inquilino();
		inqui.setIdInquilino(idInquilino);
		inqui.setNombre(nombre);
		inqui.setDni(dni);
		inqui.setEdad(edad);	
		inqui.setTrabaja(trabaja);
		
		Set<Inmueble> s=new HashSet<Inmueble>();
		for (Integer inmueble : idInmueble) {
			Inmueble i=new Inmueble();
			i.setIdInmueble(inmueble);
			s.add(i);
		}
		inqui.setInmuebles(s);
		
		return inqui;
	}
	
	public void fromInquilino(Inquilino inqui) {
		setIdInquilino(inqui.getIdInquilino());	
		setNombre(inqui.getNombre());
		setDni(inqui.getDni());
		setEdad(inqui.getEdad());
		setTrabaja(inqui.getTrabaja());
		
		idInmueble=new Integer[inqui.getInmuebles().size()];
		int i=0;
		for (Inmueble inmueble : inqui.getInmuebles()) {
			idInmueble[i++]=inmueble.getIdInmueble();
		}	
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

	public Integer[] getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Integer[] idInmueble) {
		this.idInmueble = idInmueble;
	}

}

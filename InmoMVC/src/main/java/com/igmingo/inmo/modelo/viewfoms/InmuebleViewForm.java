package com.igmingo.inmo.modelo.viewfoms;

import com.igmingo.inmo.modelo.Inmueble;
import com.igmingo.inmo.modelo.Inquilino;
import com.igmingo.inmo.modelo.Propietario;

public class InmuebleViewForm {

    private Integer idInmueble;
    private Inquilino inquilino;
    private Propietario propietario;
    private String direccion;
    private double precio;
    
	public InmuebleViewForm(Integer idInmueble, Inquilino inquilino,
			Propietario propietario, String direccion, double precio) {
		super();
		this.idInmueble = idInmueble;
		this.inquilino = inquilino;
		this.propietario = propietario;
		this.direccion = direccion;
		this.precio = precio;
	}
	
	public InmuebleViewForm() {
		super();
	}
	
	
	public Inmueble getInmueble() {
		Inmueble inmueble=new Inmueble();
		
		inmueble.setIdInmueble(idInmueble);
		inmueble.setDireccion(direccion);
		inmueble.setPrecio(precio);

		inmueble.setPropietario(propietario);
		inmueble.setInquilino(inquilino);
		
		return inmueble;
	}
	
	//Le paso un TiendaProducto y lo coloca en un ProductoViewForm
	public void fromInmueble(Inmueble inmueble) {
		//		idProducto=prod.getIdProducto(); es lo mismo
		setIdInmueble(inmueble.getIdInmueble());		
		setDireccion(inmueble.getDireccion());
		setPrecio(inmueble.getPrecio());
		
		setInquilino(inmueble.getInquilino());
		setPropietario(inmueble.getPropietario());
	}
    
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public Inquilino getInquilino() {
		return inquilino;
	}
	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

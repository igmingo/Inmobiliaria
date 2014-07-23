package com.igmingo.inmo.modelo;
// Generated 23-jul-2014 16:05:59 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * Inmueble generated by hbm2java
 */
@Entity
@Table(name="Inmueble"
    ,catalog="teide2014"
)

@NamedQuery (name="inmueble.buscador", query="from Inmueble e where e.direccion like :textobuscar")
public class Inmueble  implements java.io.Serializable {


     private Integer idInmueble;
     private Inquilino inquilino;
     private Propietario propietario;
     private String direccion;
     private double precio;

    public Inmueble() {
    }

	
    public Inmueble(Propietario propietario, String direccion, double precio) {
        this.propietario = propietario;
        this.direccion = direccion;
        this.precio = precio;
    }
    public Inmueble(Inquilino inquilino, Propietario propietario, String direccion, double precio) {
       this.inquilino = inquilino;
       this.propietario = propietario;
       this.direccion = direccion;
       this.precio = precio;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idInmueble", unique=true, nullable=false)
    public Integer getIdInmueble() {
        return this.idInmueble;
    }
    
    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idInquilino")
    public Inquilino getInquilino() {
        return this.inquilino;
    }
    
    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPropietario", nullable=false)
    public Propietario getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    
    @Column(name="direccion", nullable=false, length=455)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="precio", nullable=false, precision=22, scale=0)
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }




}



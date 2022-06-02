package com.digi.app.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "prestamos_hipotecarios")
@DiscriminatorValue(value ="Hipotecario")
public class PrestamoHipotecario extends Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String tipoInmueble;


	public String getTipoInmueble() {
		return tipoInmueble;
	}


	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	

	

	
	
	
	
	
	
	
}

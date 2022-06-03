package com.digi.app.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "prestamos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public Prestamo(Long idPres, double valorCuota, double cantCuota) {
		super();
		this.idPres = idPres;
		this.valorCuota = valorCuota;
		this.cantCuota = cantCuota;
	}

	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPres;
	private String nombre;
	
	private double valorCuota;
	@Min(12)
	@Max(240)
	private double cantCuota;

	public double getValorCuota() {
		return valorCuota;
	}

	public Long getIdPres() {
		return idPres;
	}

	public void setIdPres(Long idPres) {
		this.idPres = idPres;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}

	public double getCantCuota() {
		return cantCuota;
	}

	public void setCantCuota(double cantCuota) {
		this.cantCuota = cantCuota;
	}

}

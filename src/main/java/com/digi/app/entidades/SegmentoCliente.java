package com.digi.app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "segmento_clientes")
public class SegmentoCliente implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public SegmentoCliente(Long idSegmClient, String segmento) {
		super();
		this.idSegmClient = idSegmClient;
		this.segmento = segmento;
	}
	

	public SegmentoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSegmClient;
	
	private String segmento;

	public Long getIdSegmClient() {
		return idSegmClient;
	}

	public void setIdSegmClient(Long idSegmClient) {
		this.idSegmClient = idSegmClient;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	
	
	
	
}

package com.digi.app.servicios;

import java.util.List;


import com.digi.app.entidades.SegmentoCliente;

public interface ISegmentoService{

	public List<SegmentoCliente> findAll();

	public SegmentoCliente save(SegmentoCliente sCli);
	
	public SegmentoCliente findOne(Long idSegmClient);
	
	public void delete(Long idSegmClient);
}

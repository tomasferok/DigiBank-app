package com.digi.app.servicios;

import java.util.List;

import com.digi.app.entidades.PrestamoHipotecario;

public interface IPrestamoHipotecarioService {
	public List<PrestamoHipotecario> findAll();

	public PrestamoHipotecario save(PrestamoHipotecario prestHip);
	
	public PrestamoHipotecario findOne(Long idPrestHip);
	
	public void delete(Long idPrestHip);
}

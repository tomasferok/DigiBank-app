package com.digi.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.app.daos.PrestamoHipotecarioDao;
import com.digi.app.entidades.PrestamoHipotecario;

@Service
public class PrestamoHipotecarioService implements IPrestamoHipotecarioService{

	@Autowired
	PrestamoHipotecarioDao prestHipService;
	@Override
	public List<PrestamoHipotecario> findAll() {
		// TODO Auto-generated method stub
		return (List<PrestamoHipotecario>) prestHipService.findAll();
	}

	@Override
	public PrestamoHipotecario save(PrestamoHipotecario prestHip) {
		// TODO Auto-generated method stub
		return prestHipService.save(prestHip);
	}

	@Override
	public PrestamoHipotecario findOne(Long idPrestHip) {
		// TODO Auto-generated method stub
		return prestHipService.findById(idPrestHip).orElse(null);
	}

	@Override
	public void delete(Long idPrestHip) {
		prestHipService.deleteById(idPrestHip);		
	}

}

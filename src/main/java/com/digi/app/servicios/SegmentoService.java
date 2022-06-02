package com.digi.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.app.daos.SegmentoDao;
import com.digi.app.entidades.SegmentoCliente;

@Service
public class SegmentoService implements ISegmentoService {

	@Autowired
	SegmentoDao sDaoService;
	@Override
	public List<SegmentoCliente> findAll() {
		// TODO Auto-generated method stub
		return (List<SegmentoCliente>) sDaoService.findAll();
	}

	@Override
	public SegmentoCliente save(SegmentoCliente sCli) {
		// TODO Auto-generated method stub
		return sDaoService.save(sCli);
	}

	@Override
	public SegmentoCliente findOne(Long idSegmClient) {
		// TODO Auto-generated method stub
		return sDaoService.findById(idSegmClient).orElse(null);
	}

	@Override
	public void delete(Long idSegmClient) {
		// TODO Auto-generated method stub
		sDaoService.deleteById(idSegmClient);
	}

}

package com.digi.app.servicios;

import java.util.List;

import com.digi.app.entidades.Producto;



public interface IProductoService {
	public List<Producto> findAll();

	public Producto save(Producto producto);
	
	public Producto findOne(Long idProd);
	
	public void delete(Long idProd);
}


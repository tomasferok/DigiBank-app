package com.digi.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.app.daos.ProductoDao;
import com.digi.app.entidades.Producto;

@Service
public class ProductoSevice implements IProductoService {
	@Autowired
	ProductoDao productoService;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoService.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoService.save(producto);
	}

	@Override
	public Producto findOne(Long idProd) {
		// TODO Auto-generated method stub
		return productoService.findById(idProd).orElse(null);
	}

	@Override
	public void delete(Long idProd) {
		productoService.deleteById(idProd);
	}

}

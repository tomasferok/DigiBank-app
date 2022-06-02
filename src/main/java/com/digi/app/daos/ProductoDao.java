package com.digi.app.daos;

import org.springframework.data.repository.CrudRepository;

import com.digi.app.entidades.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}

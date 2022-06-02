package com.digi.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digi.app.entidades.Producto;
import com.digi.app.entidades.SegmentoCliente;
import com.digi.app.servicios.IProductoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductoRest {

	@Autowired
	IProductoService productoService;

	@GetMapping("/prod")
	public List<Producto> index() {

		return productoService.findAll();
	}

	@GetMapping("/prod/{idProd}")
	public ResponseEntity<?> show(@PathVariable Long idProd) {

		Producto p = null;
		Map<String, Object> response = new HashMap<>();

		try {

			p = productoService.findOne(idProd);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al buscar el producto");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (p == null) {
			response.put("mensaje",
					"El producto ID ".concat(idProd.toString()).concat(" no existe en la base de datos"));
		}
		return new ResponseEntity<Producto>(p, HttpStatus.OK);
	}

	@PostMapping("/prod")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Producto prod) {
		Producto prodNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productoService.save(prod);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al crear el producto");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}

		if (prod.getTipoProdHip().getTipoInmueble() != "casa"
				|| prod.getTipoProdHip().getTipoInmueble() != "apartamento"
				|| prod.getTipoProdHip().getTipoInmueble() != "campo"
				|| prod.getTipoProdAuto().getTipoVehiculo() != "auto"
				|| prod.getTipoProdAuto().getTipoVehiculo() != "camioneta") {
			response.put("mensaje",
					"El tipo de inmueble o tipo de vehiculo no puede ser distinto de 'casa, apartamento o campo', 'auto, camioneta'");
		}
		if (prod.getTipoProdDep().getTipo() != "caja de ahorro"
				|| prod.getTipoProdDep().getTipo() != "cuenta corriente") {
			response.put("mensaje",
					"tipo de deposito invalido estos deben ser: caja de ahorro o cuenta corriente");
		}
		if (prod.getTipoProdDep().getMoneda() != "euro" || prod.getTipoProdDep().getMoneda() != "dolar")
			response.put("mensaje", "no se aceptan divisas diferentes a euro o dolar");
		response.put("prod", prodNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/prod/{idProd}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto prod, @PathVariable Long idProd) {
		Producto prodActual = productoService.findOne(idProd);

		prodActual.setNombre(prod.getNombre());

		return productoService.save(prodActual);
	}

	@DeleteMapping("/prod/{idProd}")
	public void delete(@PathVariable Long idProd) {
		productoService.delete(idProd);
	}
}

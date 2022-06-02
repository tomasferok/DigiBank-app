package com.digi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digi.app.entidades.PrestamoHipotecario;
import com.digi.app.servicios.IPrestamoHipotecarioService;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/api")
public class PrestamoHipotecarioRest {
	
	@Autowired
	IPrestamoHipotecarioService prestHipService;
	
	@GetMapping("/prestHip")
	public List<PrestamoHipotecario> index(){
		return prestHipService.findAll();
	}

	@GetMapping("/prestHip/{idPrestHip}")
	public PrestamoHipotecario show(@PathVariable Long idPrestHip) {

		return prestHipService.findOne(idPrestHip);
	}
	@PostMapping("/prestHip")
	@ResponseStatus(HttpStatus.CREATED)
	public PrestamoHipotecario create(@RequestBody PrestamoHipotecario prestHip) {
		return prestHipService.save(prestHip);
		
}

}

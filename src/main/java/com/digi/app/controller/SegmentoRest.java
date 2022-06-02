package com.digi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digi.app.entidades.SegmentoCliente;
import com.digi.app.servicios.ISegmentoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SegmentoRest {
	@Autowired
	ISegmentoService segService;

	@GetMapping("/segment")
	public List<SegmentoCliente> index() {
		return segService.findAll();
	}

	@GetMapping("/segment/{idSegmClient}")
	public SegmentoCliente show(@PathVariable Long idSegmClient) {

		return segService.findOne(idSegmClient);
	}

	@PostMapping("/segment")
	@ResponseStatus(HttpStatus.CREATED)
	public SegmentoCliente create(@RequestBody SegmentoCliente sCli) {
		return segService.save(sCli);

	}

	@DeleteMapping("/segment/{idSegmClient}")
	public void delete(@PathVariable Long idSegmClient) {
		segService.delete(idSegmClient);
	}
}

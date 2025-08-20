package com.example.prueba.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.application.service.factura.FacturaApplicationServiceDefault;

@RestController
@RequestMapping("factura")
public class FacturaController {

	private final FacturaApplicationServiceDefault facturaService;

	public FacturaController(FacturaApplicationServiceDefault facturaService) {
		this.facturaService = facturaService;
	}

	@PostMapping
	public ResponseEntity<Factura> save(@RequestBody Factura factura) {
		Factura saved = facturaService.save(factura);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}

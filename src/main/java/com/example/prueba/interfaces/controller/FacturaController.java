package com.example.prueba.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.application.dto.FacturaDTO;
import com.example.prueba.application.service.factura.FacturaApplicationService;

@RestController
@RequestMapping("factura")
public class FacturaController {

	@Autowired
	FacturaApplicationService factura;

	@PostMapping
	public ResponseEntity<FacturaDTO> save(@RequestBody FacturaDTO entity) throws Exception {
		return new ResponseEntity<FacturaDTO>(factura.save(entity), HttpStatus.CREATED);
	}

	@PostMapping("/generar-pdf")
	public ResponseEntity<ByteArrayResource> generarFacturaPdf(@RequestBody FacturaDTO facturaDTO) throws Exception {
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=factura.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new ByteArrayResource(factura.generarFacturaPdf(facturaDTO)));
	}
}

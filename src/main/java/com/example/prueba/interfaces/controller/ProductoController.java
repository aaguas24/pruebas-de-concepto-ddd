package com.example.prueba.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.service.producto.ProductoApplicationService;

@RestController
@RequestMapping("productos")
public class ProductoController {

	@Autowired
	ProductoApplicationService productoService;

	@PostMapping
	public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO producto) throws Exception {
		return new ResponseEntity<ProductoDTO>(productoService.save(producto).get(), HttpStatus.CREATED);
	}
}

package com.example.prueba.application.service;

import java.util.UUID;

import com.example.prueba.application.dto.ProductoDTO;

public interface ProductoService {

	ProductoDTO save(ProductoDTO producto)throws Exception ;
	
	ProductoDTO findById(UUID id)throws Exception ;
}

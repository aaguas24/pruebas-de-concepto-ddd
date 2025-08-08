package com.example.prueba.infrastructure.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.prueba.application.dto.ProductoDTO;
import com.example.prueba.application.mapper.ProductoMapper;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.application.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository;

	private final ProductoMapper productoMapper;

	public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
		this.productoRepository = productoRepository;
		this.productoMapper = productoMapper;
	}

	@Override
	public ProductoDTO save(ProductoDTO producto) throws Exception {
		try {
			return productoMapper.toProductoDTO(productoRepository.save(productoMapper.toProducto(producto)));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ProductoDTO findById(UUID id) throws Exception {
		try {
			return productoMapper.toProductoDTO(productoRepository.findById(id).get());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}

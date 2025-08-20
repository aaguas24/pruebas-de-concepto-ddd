package com.example.prueba.infrastructure.repository.adapter;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.repository.ProductoRepository;

@Service
public class ProductoJpaRepositoryAdapter implements ProductoRepository {

	private final ProductoRepository productoRepository;

	public ProductoJpaRepositoryAdapter(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Optional<Producto> save(Producto producto) throws Exception {
		try {
			return productoRepository.save(producto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Producto> findById(UUID id) throws Exception {
		try {
			return productoRepository.findById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}

package com.example.prueba.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.infrastructure.repository.ProductoJpaRepository;

@Service
public class ProductoJpaRepositoryAdapter implements ProductoRepository {

	private final ProductoJpaRepository productoRepository;

	public ProductoJpaRepositoryAdapter(ProductoJpaRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> buscarPorId(UUID id) {

		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> buscarPorCategoria(String categoria) {

		return productoRepository.findByCategoria(categoria);
	}

}

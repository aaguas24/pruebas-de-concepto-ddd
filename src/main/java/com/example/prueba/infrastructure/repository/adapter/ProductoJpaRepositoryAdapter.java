package com.example.prueba.infrastructure.repository.adapter;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.Factura;
import com.example.prueba.infrastructure.mapper.ProductoEntityMapper;
import com.example.prueba.shared.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.Producto;
import com.example.prueba.domain.repository.ProductoRepository;
import com.example.prueba.infrastructure.repository.ProductoJpaRepository;
import com.example.prueba.infrastructure.repository.entity.ProductoEntity;

@AllArgsConstructor
@Service
public class ProductoJpaRepositoryAdapter implements ProductoRepository {
	private static final Logger logger = LoggerFactory.getLogger(ProductoJpaRepositoryAdapter.class);
	private final ProductoJpaRepository productoJpaRepository;
	private final ProductoEntityMapper productoEntityMapper;

	@Override
	public Optional<Producto> save(Producto producto) {
		try {
			ProductoEntity entity = productoEntityMapper.toEntity(producto);
			ProductoEntity saved = productoJpaRepository.save(entity);
			return Optional.ofNullable(productoEntityMapper.toDomain(saved));
		} catch (Exception e) {
			logger.error("Error en ProductoJpaRepositoryAdapter - save: {}", e.getMessage());
			throw new ServiceException("Error al guardar el producto");
		}
	}

	@Override
	public Optional<Producto> findById(UUID id) {
		try {
			return productoJpaRepository.findById(id).map(productoEntityMapper::toDomain);
		} catch (Exception e) {
			logger.error("Error en ProductoJpaRepositoryAdapter - findById: {}", e.getMessage());
			throw new ServiceException("Error al buscar el producto por ID");
		}
	}

}

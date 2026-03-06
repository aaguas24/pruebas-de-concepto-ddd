package com.example.prueba.infrastructure.repository.adapter;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.infrastructure.mapper.DetalleFacturaEntityMapper;
import com.example.prueba.shared.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.prueba.domain.entity.DetalleFactura;
import com.example.prueba.domain.repository.DetalleFacturaRepository;
import com.example.prueba.infrastructure.repository.DetalleFacturaJpaRepository;
import com.example.prueba.infrastructure.repository.entity.DetalleFacturaEntity;

@AllArgsConstructor
@Service
public class DetalleFacturaJpaRepositoryAdapter implements DetalleFacturaRepository {
	private static final Logger logger = LoggerFactory.getLogger(DetalleFacturaJpaRepositoryAdapter.class);

	private final DetalleFacturaJpaRepository detalleFacturaJpaRepository;

	private final DetalleFacturaEntityMapper detalleFacturaEntityMapper;

	@Override
	public Optional<DetalleFactura> save(DetalleFactura detalleFactura) throws Exception {
		try {
			DetalleFacturaEntity entity = detalleFacturaEntityMapper.toEntity(detalleFactura);
			DetalleFacturaEntity saved = detalleFacturaJpaRepository.save(entity);
			return Optional.ofNullable(detalleFacturaEntityMapper.toDomain(saved));
		} catch (Exception e) {
			logger.error("Error al save DetalleFactura {}", e.getMessage());
			throw new ServiceException(e.getMessage());
		}

	}

	@Override
	public Optional<DetalleFactura> findById(UUID id) throws Exception {
		try {
			return detalleFacturaJpaRepository.findById(id).map(detalleFacturaEntityMapper::toDomain);
		} catch (Exception e) {
			logger.error("Error al save DetalleFactura {}", e.getMessage());
			throw new ServiceException(e.getMessage());
		}

	}

}

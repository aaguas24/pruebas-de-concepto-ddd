package com.example.prueba.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.prueba.domain.entity.DetalleFactura;

public interface DetalleFacturaRepository {
	Optional<DetalleFactura> save(DetalleFactura detalleFactura) throws Exception;

	Optional<DetalleFactura> findById(UUID id) throws Exception;
}
